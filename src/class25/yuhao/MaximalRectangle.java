package class25.yuhao;

import java.util.Stack;

/**
 * 给定一个二维数组matrix，其中的值不是0就是1，
 * 返回全部由1组成的最大子矩形，内部有多少个1
 * https://leetcode.com/problems/maximal-rectangle/
 */
public class MaximalRectangle {
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
}
