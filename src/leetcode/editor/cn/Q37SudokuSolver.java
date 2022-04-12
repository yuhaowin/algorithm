package leetcode.editor.cn;

public class Q37SudokuSolver {
    public static void main(String[] args) {
        Solution solution = new Q37SudokuSolver().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void solveSudoku(char[][] board) {
            boolean[][] row = new boolean[9][10];
            boolean[][] colum = new boolean[9][10];
            boolean[][] sub = new boolean[9][10];
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] == '.') {
                        continue;
                    }
                    int x = 3 * (i / 3) + (j / 3);
                    int num = board[i][j] - '0';
                    row[i][num] = true;
                    colum[j][num] = true;
                    sub[x][num] = true;
                }
            }
            process(board, 0, 0, row, colum, sub);
        }

        private boolean process(char[][] board, int i, int j, boolean[][] row, boolean[][] colum, boolean[][] sub) {
            if (i == 9) {
                return true;
            }
            // 下一个位置
            int nextI = j == 8 ? i + 1 : i;
            int nextJ = j == 8 ? 0 : j + 1;
            if (board[i][j] != '.') {
                return process(board, nextI, nextJ, row, colum, sub);
            } else {
                int x = 3 * (i / 3) + (j / 3);
                for (int k = 1; k <= 9; k++) {
                    if (!row[i][k] && !colum[j][k] && !sub[x][k]) {
                        row[i][k] = true;
                        colum[j][k] = true;
                        sub[x][k] = true;
                        board[i][j] = (char) (k + '0');
                        if (process(board, nextI, nextJ, row, colum, sub)) {
                            return true;
                        }
                        row[i][k] = false;
                        colum[j][k] = false;
                        sub[x][k] = false;
                        board[i][j] = '.';
                    }
                }
                return false;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}