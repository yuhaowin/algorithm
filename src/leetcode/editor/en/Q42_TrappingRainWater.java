package leetcode.editor.en;

import java.util.Stack;

public class Q42_TrappingRainWater {
    public static void main(String[] args) {
        Solution solution = new Q42_TrappingRainWater().new Solution();
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(solution.trap(height));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trap(int[] height) {
            int ans = 0;
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < height.length; i++) {
                while (!stack.isEmpty() && height[stack.peek()] <= height[i]) {
                    int index = stack.pop();
                    int leftIndex = stack.isEmpty() ? -1 : stack.peek();
                    if (leftIndex != -1) {
                        int x = i - leftIndex - 1;
                        int y = Math.min(height[leftIndex], height[i]) - height[index];
                        ans += x * y;
                    }
                }
                stack.push(i);
            }
            return ans;
        }

        public int trap1(int[] height) {
            int length = height.length;
            int[] left = new int[length];
            int[] right = new int[length];
            left[0] = height[0];
            for (int i = 1; i < length; i++) {
                if (left[i - 1] < height[i]) {
                    left[i] = height[i];
                } else {
                    left[i] = left[i - 1];
                }
            }
            right[length - 1] = height[length - 1];
            for (int i = length - 2; i >= 0; i--) {
                if (right[i + 1] > height[i]) {
                    right[i] = right[i + 1];
                } else {
                    right[i] = height[i];
                }
            }
            int result = 0;
            for (int i = 0; i < length; i++) {
                int min = Math.min(left[i], right[i]);
                result += Math.max(0, min - height[i]);
            }
            return result;
        }

        public int trap2(int[] height) {
            int length = height.length;
            if (length < 3) {
                return 0;
            }
            int L = 0;
            int R = length - 1;
            int leftMax = height[0];
            int rightMax = height[length - 1];

            int result = 0;
            while (L <= R) {
                if (leftMax <= rightMax) {
                    result += Math.max(0, leftMax - height[L]);
                    if (leftMax < height[L]) {
                        leftMax = height[L];
                    }
                    L++;
                } else {
                    result += Math.max(0, rightMax - height[R]);
                    if (rightMax < height[R]) {
                        rightMax = height[R];
                    }
                    R--;
                }
            }
            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}