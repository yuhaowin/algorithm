package leetcode.editor.en;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q73_SetMatrixZeroes {
    public static void main(String[] args) {
        Solution solution = new Q73_SetMatrixZeroes().new Solution();
        int[][] matrix = new int[][]{
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        solution.setZeroes(matrix);

        Arrays.stream(matrix).forEach(it -> {
            Arrays.stream(it).forEach(x -> System.out.print(x + " "));
            System.out.println();
        });
        System.out.println();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void setZeroes(int[][] matrix) {
            int n = matrix.length;
            int m = matrix[0].length;
            Set<Integer> row = new HashSet<>();
            Set<Integer> col = new HashSet<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (matrix[i][j] == 0) {
                        row.add(i);
                        col.add(j);
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (row.contains(i) || col.contains(j)) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}