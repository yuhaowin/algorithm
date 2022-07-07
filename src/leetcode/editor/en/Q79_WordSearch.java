package leetcode.editor.en;

public class Q79_WordSearch {
    public static void main(String[] args) {
        Solution solution = new Q79_WordSearch().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 深度优先 + 增加现场
        public boolean exist(char[][] board, String word) {
            char[] w = word.toCharArray();
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (process(board, i, j, w, 0)) {
                        return true;
                    }
                }
            }
            return false;
        }

        // 目前到达 board[i][j],w[k]
        // 从 board[i][j] 出发,能不能搞定 w[k....] 能 true 不能 false
        private boolean process(char[][] board, int i, int j, char[] w, int k) {
            if (k == w.length) {
                return true;
            }
            if (i < 0 || i == board.length || j < 0 || j == board[0].length) {
                return false;
            }
            if (board[i][j] != w[k]) {
                return false;
            }

            char temp = board[i][j];
            board[i][j] = 0;
            boolean p1 = process(board, i - 1, j, w, k + 1);
            boolean p2 = process(board, i + 1, j, w, k + 1);
            boolean p3 = process(board, i, j - 1, w, k + 1);
            boolean p4 = process(board, i, j + 1, w, k + 1);
            board[i][j] = temp;
            return p1 || p2 || p3 || p4;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}