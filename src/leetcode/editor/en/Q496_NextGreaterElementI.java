package leetcode.editor.en;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Q496_NextGreaterElementI {
    public static void main(String[] args) {
        Solution solution = new Q496_NextGreaterElementI().new Solution();
        int[] num1 = new int[]{4, 1, 2};
        int[] num2 = new int[]{1, 3, 4, 2};
        Arrays.stream(solution.nextGreaterElement(num1, num2)).forEach(it -> System.out.print(it + " "));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            Map<Integer, Integer> map = new HashMap<>();
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < nums2.length; i++) {
                while (!stack.isEmpty() && nums2[stack.peek()] < nums2[i]) {
                    map.put(nums2[stack.pop()], i);
                }
                stack.push(i);
            }
            while (!stack.isEmpty()) {
                map.put(nums2[stack.pop()], -1);
            }

            for (int i = 0; i < nums1.length; i++) {
                int index = map.get(nums1[i]);
                nums1[i] = index == -1 ? -1 : nums2[index];
            }
            return nums1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}