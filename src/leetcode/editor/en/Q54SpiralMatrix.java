package leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

public class Q54SpiralMatrix {
    public static void main(String[] args) {
        Solution solution = new Q54SpiralMatrix().new Solution();
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        solution.spiralOrder(matrix).stream().forEach(item -> System.out.print(item + " "));
        matrix = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        System.out.println();
        solution.spiralOrder(matrix).stream().forEach(item -> System.out.print(item + " "));
        matrix = new int[][]{
                {7},
                {9},
                {6}
        };
        System.out.println();
        solution.spiralOrder(matrix).stream().forEach(item -> System.out.print(item + " "));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            int a = 0;
            int b = 0;
            int x = matrix.length - 1;
            int y = matrix[0].length - 1;
            List<Integer> result = new ArrayList<>();

            while (a <= x && b <= y) {
                test(matrix, a++, b++, x--, y--, result);
            }

            return result;
        }

        private void test(int[][] matrix, int a, int b, int x, int y, List<Integer> result) {
            if (a == x) {
                for (int i = b; i <= y; i++) {
                    result.add(matrix[a][i]);
                }
            } else if (b == y) {
                for (int i = a; i <= x; i++) {
                    result.add(matrix[i][b]);
                }

            } else {
                for (int i = b; i <= y - 1; i++) {
                    result.add(matrix[a][i]);
                }

                for (int i = a; i <= x - 1; i++) {
                    result.add(matrix[i][y]);
                }

                for (int i = y; i >= b + 1; i--) {
                    result.add(matrix[x][i]);
                }

                for (int i = x; i >= a + 1; i--) {
                    result.add(matrix[i][b]);
                }
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}