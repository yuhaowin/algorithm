package leetcode.editor.en;

public class Q63_UniquePathsIi {
    public static void main(String[] args) {
        Solution solution = new Q63_UniquePathsIi().new Solution();
        int[][] obstacle = new int[][]{
                {0, 0, 0}
                , {0, 1, 0}
                , {0, 0, 0}
        };
        System.out.println(solution.uniquePathsWithObstacles(obstacle) == 2);
        System.out.println(solution.dp0(obstacle) == 2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            //return process(0, 0, obstacleGrid);
            return dp1(obstacleGrid);
        }

        private int process(int x, int y, int[][] obstacleGrid) {
            int m = obstacleGrid.length - 1;
            int n = obstacleGrid[0].length - 1;
            boolean isObstacle = obstacleGrid[x][y] == 1;
            if (isObstacle) {
                return 0;
            }
            if (x == m && y == n) {
                return 1;
            }
            if (x == m) {
                return process(x, y + 1, obstacleGrid);
            }
            if (y == n) {
                return process(x + 1, y, obstacleGrid);
            }
            int right = process(x + 1, y, obstacleGrid);
            int down = process(x, y + 1, obstacleGrid);
            return right + down;
        }

        //--------------------------------------------------------------------------------------------------------------

        private int dp0(int[][] obstacleGrid) {
            int m = obstacleGrid.length - 1;
            int n = obstacleGrid[0].length - 1;

            int[][] dp = new int[m + 1][n + 1];
            dp[m][n] = obstacleGrid[m][n] == 1 ? 0 : 1;
            for (int i = n - 1; i >= 0; i--) {
                dp[m][i] = obstacleGrid[m][i] == 1 ? 0 : dp[m][i + 1];
            }

            for (int i = m - 1; i >= 0; i--) {
                dp[i][n] = obstacleGrid[i][n] == 1 ? 0 : dp[i + 1][n];
            }

            for (int i = m - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : dp[i][j + 1] + dp[i + 1][j];
                }
            }
            return dp[0][0];
        }

        private int dp1(int[][] obstacleGrid) {
            int m = obstacleGrid.length - 1;
            int n = obstacleGrid[0].length - 1;
            int[] pre = new int[n + 1];
            int[] cur = new int[n + 1];

            pre[n] = obstacleGrid[m][n] == 1 ? 0 : 1;
            for (int i = n - 1; i >= 0; i--) {
                pre[i] = obstacleGrid[m][i] == 1 ? 0 : pre[i + 1];
            }

            cur = pre.clone();

            for (int i = m - 1; i >= 0; i--) {
                for (int j = n; j >= 0; j--) {
                    boolean isObstacle = obstacleGrid[i][j] == 1;
                    if (j == n) {
                        cur[j] = isObstacle ? 0 : pre[j];
                    } else {
                        cur[j] = isObstacle ? 0 : pre[j] + cur[j + 1];
                    }
                }
                pre = cur.clone();
            }
            return cur[0];

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}