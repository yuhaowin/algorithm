package leetcode.editor.cn;

public class Q36ValidSudoku {
    public static void main(String[] args) {
        Solution solution = new Q36ValidSudoku().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValidSudoku(char[][] board) {
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
                    if (row[i][num] || colum[j][num] || sub[x][num]) {
                        return false;
                    }
                    row[i][num] = true;
                    colum[j][num] = true;
                    sub[x][num] = true;
                }
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}