package leetcode.editor.en;

import java.util.Stack;

public class Q84_LargestRectangleInHistogram {
    public static void main(String[] args) {
        Solution solution = new Q84_LargestRectangleInHistogram().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int largestRectangleArea(int[] heights) {
            Stack<Integer> stack = new Stack<>();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < heights.length; i++) {
                while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                    int height = heights[stack.pop()];
                    int k = stack.isEmpty() ? -1 : stack.peek();
                    int weight = (i - k - 1);
                    max = Math.max(max, height * weight);
                }
                stack.push(i);
            }
            while (!stack.isEmpty()) {
                int height = heights[stack.pop()];
                int k = stack.isEmpty() ? -1 : stack.peek();
                //想象一下右边有一个高度为0的
                int weight = (heights.length - k - 1);
                max = Math.max(max, height * weight);
            }
            return max;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}