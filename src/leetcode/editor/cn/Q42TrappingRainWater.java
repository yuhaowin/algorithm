package leetcode.editor.cn;

public class Q42TrappingRainWater {
    public static void main(String[] args) {
        Solution solution = new Q42TrappingRainWater().new Solution();
        int[] height = new int[]{4, 2, 0, 3, 2, 5};
        height = new int[]{5, 5, 1, 7, 1, 1, 5, 2, 7, 6};
        System.out.println(solution.trap(height));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trap1(int[] height) {
            int length = height.length;
            int[] left = new int[height.length];
            int[] right = new int[height.length];

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
                int max = Math.max(0, min - height[i]);
                result += max;
            }

            return result;
        }

        public int trap(int[] height) {
            int length = height.length;
            if (length < 3) {
                return 0;
            }

            int L = 0;
            int R = length - 1;
            int result = 0;

            int leftMax = height[0];
            int rightMax = height[length - 1];

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