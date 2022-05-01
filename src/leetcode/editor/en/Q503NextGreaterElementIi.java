package leetcode.editor.en;

import java.util.Arrays;
import java.util.Stack;

public class Q503NextGreaterElementIi {
    public static void main(String[] args) {
        Solution solution = new Q503NextGreaterElementIi().new Solution();
        int[] nums = new int[]{1, 2, 3, 4, 3};
        Arrays.stream(solution.nextGreaterElements(nums)).forEach(it -> System.out.print(it + " "));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] nextGreaterElements1(int[] nums) {
            int N = nums.length;
            int[] ans = new int[N];
            int[] ans2 = new int[N * 2];
            int[] temp = new int[N * 2];
            for (int i = 0; i < N; i++) {
                temp[i] = temp[N + i] = nums[i];
            }
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < N * 2; i++) {
                while (!stack.isEmpty() && temp[stack.peek()] < temp[i]) {
                    int index = stack.pop();
                    ans2[index] = temp[i];
                    if (index < N) {
                        ans[index] = temp[i];
                    }
                }
                stack.push(i);
            }
            while (!stack.isEmpty()) {
                int index = stack.pop();
                ans2[index] = -1;
                if (index < N) {
                    ans[index] = -1;
                }
            }
            return ans;
        }

        public int[] nextGreaterElements2(int[] nums) {
            int N = nums.length;
            int[] ans = new int[N];
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < N * 2 - 1; i++) {
                while (!stack.isEmpty() && nums[stack.peek()] < nums[i % N]) {
                    ans[stack.pop()] = nums[i % N];
                }
                stack.push(i % N);
            }
            while (!stack.isEmpty()) {
                ans[stack.pop()] = -1;
            }
            return ans;
        }

        public int[] nextGreaterElements(int[] nums) {
            int N = nums.length;
            int[] ans = new int[N];
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < N; i++) {
                while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                    ans[stack.pop()] = nums[i];
                }
                stack.push(i);
            }
            for (int i = 0; i < N - 1; i++) {
                while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                    ans[stack.pop()] = nums[i];
                }
            }
            while (!stack.isEmpty()) {
                ans[stack.pop()] = -1;
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}