package leetcode.editor.en;

public class Q48RotateImage {
    public static void main(String[] args) {
        Solution solution = new Q48RotateImage().new Solution();
        int[][] matrix = new int[][]{
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        solution.rotate(matrix);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void rotate(int[][] matrix) {
            int a = 0;
            int b = 0;
            int x = matrix.length - 1;
            int y = matrix.length - 1;
            while (a < x) {
                process(matrix, a++, b++, x--, y--);
            }
        }

        private void process(int[][] matrix, int a, int b, int x, int y) {
            int times = x - a;
            for (int i = 0; i < times; i++) {
                int temp = matrix[a][b + i];
                matrix[a][b + i] = matrix[x - i][b];
                matrix[x - i][b] = matrix[x][y - i];
                matrix[x][y - i] = matrix[a + i][y];
                matrix[a + i][y] = temp;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}