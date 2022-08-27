package leetcode.editor.en;

import java.util.Stack;

public class Q1856_MaximumSubarrayMinProduct {
    public static void main(String[] args) {
        Solution solution = new Q1856_MaximumSubarrayMinProduct().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSumMinProduct(int[] arr) {
            int size = arr.length;
            long[] sums = preSum(arr);
            long max = Long.MIN_VALUE;
            int[] stack = new int[size];
            int stackSize = 0;
            for (int i = 0; i < size; i++) {
                while (stackSize != 0 && arr[stack[stackSize - 1]] >= arr[i]) {
                    int j = stack[--stackSize];
                    max = Math.max(max, (stackSize == 0 ? sums[i - 1] : (sums[i - 1] - sums[stack[stackSize - 1]])) * arr[j]);
                }
                stack[stackSize++] = i;
            }
            while (stackSize != 0) {
                int j = stack[--stackSize];
                max = Math.max(max, (stackSize == 0 ? sums[size - 1] : (sums[size - 1] - sums[stack[stackSize - 1]])) * arr[j]);
            }
            return (int) (max % 1000000007);
        }

        //--------------------------------------------------------------------------------------------------------------

        public int maxSumMinProduct1(int[] arr) {
            long max = 0;
            int size = arr.length;
            long[] sums = preSum(arr);
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < size; i++) {
                while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                    long sum = 0;
                    int index = stack.pop();
                    int value = arr[index];
                    if (stack.isEmpty()) {
                        sum = sums[i - 1];
                    } else {
                        sum = sums[i - 1] - sums[stack.peek()];
                    }
                    long res = sum * value;
                    max = Math.max(max, res);
                }
                stack.push(i);
            }
            while (!stack.isEmpty()) {
                long sum = 0;
                int index = stack.pop();
                int value = arr[index];
                if (stack.isEmpty()) {
                    sum = sums[size - 1];
                } else {
                    sum = sums[size - 1] - sums[stack.peek()];
                }
                long res = sum * value;
                max = Math.max(max, res);
            }
            return (int) (max % 1000000007);
        }

        private long[] preSum(int[] arr) {
            long[] ans = new long[arr.length];
            ans[0] = arr[0];
            for (int i = 1; i < arr.length; i++) {
                ans[i] = ans[i - 1] + arr[i];
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}