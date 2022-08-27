package leetcode.editor.en;

public class Q70_ClimbingStairs {
    public static void main(String[] args) {
        Solution solution = new Q70_ClimbingStairs().new Solution();
        System.out.println(solution.climbStairs(2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 暴力递归
         */
        public int climbStairs1(int n) {
            return process(n);
        }

        private int process(int rest) {
            if (rest <= 1) {
                return 1;
            }
            int p1 = process(rest - 1);
            int p2 = process(rest - 2);
            return p1 + p2;
        }

        //--------------------------------------------------------------------------------------------------------------

        /**
         * 动态规划
         */
        public int climbStair2(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n];
        }

        //--------------------------------------------------------------------------------------------------------------

        /**
         * 动态规划 优化空间复杂度
         */
        public int climbStairs(int n) {
            int a = 1, b = 1, c = 1;
            for (int i = 2; i <= n; i++) {
                c = a + b;
                a = b;
                b = c;
            }
            return c;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}