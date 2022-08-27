package leetcode.editor.en;

public class Q11_ContainerWithMostWater {
    public static void main(String[] args) {
        Solution solution = new Q11_ContainerWithMostWater().new Solution();
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(solution.maxArea(height));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxArea(int[] height) {
            int max = 0;
            int leftIndex = 0;
            int rightIndex = height.length - 1;
            while (leftIndex < rightIndex) {
                int length = rightIndex - leftIndex;
                int width = Math.min(height[leftIndex], height[rightIndex]);
                max = Math.max(max, length * width);
                if (height[leftIndex] < height[rightIndex]) {
                    leftIndex++;
                } else {
                    rightIndex--;
                }
            }
            return max;
        }

        // time out
        public int maxArea1(int[] height) {
            int max = 0;
            int length = height.length;
            for (int i = 0; i < length; i++) {
                for (int j = 1; j < length; j++) {
                    int l = j - i;
                    int w = Math.min(height[i], height[j]);
                    max = Math.max(max, l * w);
                }
            }
            return max;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}