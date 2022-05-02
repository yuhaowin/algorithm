package leetcode.editor.en;

import java.util.Stack;

public class Q85MaximalRectangle {
    public static void main(String[] args) {
        Solution solution = new Q85MaximalRectangle().new Solution();
        char[][] matrix = new char[][]{
                {'1', '0', '1', '0', '0'}
                , {'1', '0', '1', '1', '1'}
                , {'1', '1', '1', '1', '1'}
                , {'1', '0', '0', '1', '0'}
        };
        System.out.println(solution.maximalRectangle(matrix));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximalRectangle(char[][] matrix) {
            int N = matrix.length;
            int M = matrix[0].length;
            int[] heights = new int[M];
            int max = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    heights[j] = matrix[i][j] == '0' ? 0 : heights[j] + 1;
                }
                max = Math.max(max, largestRectangleArea(heights));
            }
            return max;
        }

        public int largestRectangleArea(int[] heights) {
            int max = 0;
            int N = heights.length;
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < N; i++) {
                while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                    int index = stack.pop();
                    int height = heights[index];
                    int leftIndex = stack.isEmpty() ? -1 : stack.peek();
                    int weight = i - leftIndex - 1;
                    max = Math.max(max, height * weight);
                }
                stack.push(i);
            }
            while (!stack.isEmpty()) {
                int index = stack.pop();
                int height = heights[index];
                int leftIndex = stack.isEmpty() ? -1 : stack.peek();
                int weight = heights.length - leftIndex - 1;
                max = Math.max(max, height * weight);
            }
            return max;
        }


        public int maximalRectangle1(char[][] matrix) {
            return recursive(matrix, 0, 0);
        }

        public int recursive(char[][] matrix, int x, int y) {
            if (x == matrix.length - 1 && y == matrix[0].length - 1) {
                return matrix[x][y] == '1' ? 1 : 0;
            }
            if (x == matrix.length - 1) {
                int temp = matrix[x][y] == '1' ? 1 : 0;
                int p = recursive(matrix, x, y + 1);
                return p > 0 ? p + temp : temp;
            }
            if (y == matrix[0].length - 1) {
                int temp = matrix[x][y] == '1' ? 1 : 0;
                int p = recursive(matrix, x + 1, y);
                return p > 0 ? p + temp : temp;
            }
            int temp = matrix[x][y] == '1' ? 1 : 0;
            int p1 = recursive(matrix, x + 1, y);
            int p2 = recursive(matrix, x, y + 1);
            int p3 = recursive(matrix, x + 1, y + 1);

            int max = Math.max(p1, Math.max(p2, p3));
            return max > 0 ? max + temp : temp;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}