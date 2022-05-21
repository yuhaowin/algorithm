package leetcode.editor.en;

public class Q327_CountOfRangeSum {
    public static void main(String[] args) {
        Solution solution = new Q327_CountOfRangeSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countRangeSum(int[] nums, int lower, int upper) {
            int n = nums.length;
            long[] preSum = new long[n];
            preSum[0] = nums[0];
            for (int i = 1; i < n; i++) {
                preSum[i] = preSum[i - 1] + nums[i];
            }
            return recursive(preSum, 0, n - 1, lower, upper);
        }

        private int recursive(long[] preSum, int L, int R, int lower, int upper) {
            if (L == R) {
                // L==R 表示在 原始数组在 0-L 上的累加和，如果满足这有一个数组满足要求
                // 这个数组就是 0-L
                return preSum[L] >= lower && preSum[L] <= upper ? 1 : 0;
            }
            int M = (L + R) / 2;
            int left = recursive(preSum, L, M, lower, upper);
            int right = recursive(preSum, M + 1, R, lower, upper);
            int merge = merge(preSum, L, M, R, lower, upper);
            return left + right + merge;
        }

        private int merge(long[] preSum, int L, int M, int R, int lower, int upper) {
            //1、不 merge 但是，对于右组中的每个数 x，求左组中有多少个数，位于 [x-upper,x-lower]
            int res = 0;
            int windowL = L, windowR = L;
            for (int i = M + 1; i <= R; i++) {
                long min = preSum[i] - upper;
                long max = preSum[i] - lower;
                // 找到最左的 index 所以 <
                while (windowL <= M && preSum[windowL] < min) {
                    windowL++;
                }
                // 找到最右的 index 所以 <=
                while (windowR <= M && preSum[windowR] <= max) {
                    windowR++;
                }
                // [windowL,windowR),不用加 1
                res += windowR - windowL;
            }
            //2、正常 merge
            int i = 0;
            int p1 = L;
            int p2 = M + 1;
            long[] help = new long[R - L + 1];
            while (p1 <= M && p2 <= R) {
                if (preSum[p1] < preSum[p2]) {
                    help[i++] = preSum[p1++];
                } else {
                    help[i++] = preSum[p2++];
                }
            }
            while (p1 <= M) {
                help[i++] = preSum[p1++];
            }
            while (p2 <= R) {
                help[i++] = preSum[p2++];
            }
            for (int j = 0; j < help.length; j++) {
                preSum[L + j] = help[j];
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}