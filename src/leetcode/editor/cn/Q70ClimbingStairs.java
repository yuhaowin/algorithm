//You are climbing a staircase. It takes n steps to reach the top.
//
// Each time you can either climb 1 or 2 steps. In how many distinct ways can 
//you climb to the top? 
//
// 
// Example 1: 
//
// 
//Input: n = 2
//Output: 2
//Explanation: There are two ways to climb to the top.
//1. 1 step + 1 step
//2. 2 steps
// 
//
// Example 2: 
//
// 
//Input: n = 3
//Output: 3
//Explanation: There are three ways to climb to the top.
//1. 1 step + 1 step + 1 step
//2. 1 step + 2 steps
//3. 2 steps + 1 step
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 45 
// 
// Related Topics 记忆化搜索 数学 动态规划 👍 2345 👎 0

package leetcode.editor.cn;

public class Q70ClimbingStairs {
    public static void main(String[] args) {
        Solution solution = new Q70ClimbingStairs().new Solution();
        for (int i = 1; i <= 45; i++) {
            System.out.println(solution.climbStairs(i));
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int climbStairs(int n) {
            return dp(n);
        }

        private int process(int rest) {
            if (rest <= 0) {
                return 0;
            }
            if (rest == 1) {
                return 1;
            }
            if (rest == 2) {
                return 2;
            }
            return process(rest - 1) + process(rest - 2);
        }

        private int dp(int n) {
            if (n == 1) {
                return 1;
            }
            int[] dp = new int[n + 1];
            dp[1] = 1;
            dp[2] = 2;
            for (int i = 3; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}