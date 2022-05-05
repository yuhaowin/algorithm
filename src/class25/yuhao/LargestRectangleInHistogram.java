package class25.yuhao;

import java.util.Stack;

/**
 * 给定一个非负数组 arr，代表直方图
 * 返回直方图的最大长方形面积
 * 84:https://leetcode.com/problems/largest-rectangle-in-histogram
 */
public class LargestRectangleInHistogram {

    public static void main(String[] args) {

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
