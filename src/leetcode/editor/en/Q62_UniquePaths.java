package leetcode.editor.en;

import java.util.Arrays;

public class Q62_UniquePaths {
    public static void main(String[] args) {
        Solution solution = new Q62_UniquePaths().new Solution();
        System.out.println(solution.uniquePaths(3, 7));
        System.out.println(solution.dp0(2, 6));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int uniquePaths(int m, int n) {
            return dp2(m - 1, n - 1);
        }

        private int process(int x, int y, int m, int n) {
            if (x == m || y == n) {
                return 1;
            }
            int right = process(x + 1, y, m, n);
            int down = process(x, y + 1, m, n);
            return right + down;
        }

        private int dp0(int m, int n) {
            int[][] dp = new int[m + 1][n + 1];
            for (int i = 0; i <= n; i++) {
                dp[m][i] = 1;
            }
            for (int i = 0; i <= m; i++) {
                dp[i][n] = 1;
            }
            for (int i = m - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
                }
            }
            return dp[0][0];
        }

        private int dp1(int m, int n) {
            int[] pre = new int[n + 1];
            int[] cur = new int[n + 1];
            Arrays.fill(pre, 1);
            Arrays.fill(cur, 1);
            for (int i = m - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    cur[j] = cur[j + 1] + pre[j];
                }
                pre = cur.clone();
            }
            return cur[0];
        }

        private int dp2(int m, int n) {
            int[] cur = new int[n + 1];
            Arrays.fill(cur, 1);
            for (int i = m - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    cur[j] += cur[j + 1];
                }
            }
            return cur[0];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}