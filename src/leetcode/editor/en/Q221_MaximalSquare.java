package leetcode.editor.en;

public class Q221_MaximalSquare {
    public static void main(String[] args) {
        Solution solution = new Q221_MaximalSquare().new Solution();
        char[][] matrix = new char[][]{
                {'1', '0', '1', '0', '0'}
                , {'1', '0', '1', '1', '1'}
                , {'1', '1', '1', '1', '1'}
                , {'1', '0', '0', '1', '0'}
        };
        System.out.println(solution.maximalSquare(matrix));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximalSquare(char[][] matrix) {
            int n = matrix.length;
            if (n == 0) return 0;
            int m = matrix[0].length;
            if (m == 0) return 0;

            int[][] dp = new int[n][m];
            int maxSide = 0;
            for (int i = 0; i < n; i++) {
                dp[i][0] = matrix[i][0] == '1' ? 1 : 0;
                maxSide = Math.max(maxSide, dp[i][0]);
            }
            for (int i = 0; i < m; i++) {
                dp[0][i] = matrix[0][i] == '1' ? 1 : 0;
                maxSide = Math.max(maxSide, dp[0][i]);
            }
            for (int i = 1; i < n; i++) {
                for (int j = 1; j < m; j++) {
                    //计算dp[i][j];
                    if (matrix[i][j] == '1') {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
                        maxSide = Math.max(dp[i][j], maxSide);
                    }
                }
            }
            return maxSide * maxSide;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}