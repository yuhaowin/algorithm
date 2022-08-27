package leetcode.editor.en;

/**
 * class 6  17:30
 */
public class Q55_JumpGame {
    public static void main(String[] args) {
        Solution solution = new Q55_JumpGame().new Solution();
        int[] nums = new int[]{2, 3, 1, 1, 4};
        System.out.println(solution.canJump(nums));
        nums = new int[]{3, 2, 1, 0, 4};
        System.out.println(solution.canJump(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canJump(int[] nums) {
            if (nums == null || nums.length < 2) {
                return true;// index = 0 位置天然可以到达
            }
            int maxIndex = nums[0];//初始化最大可以到达的位置
            for (int index = 1; index < nums.length; index++) {
                if (maxIndex >= nums.length - 1) { // 优化 提前 return
                    return true;
                }
                if (index > maxIndex) {
                    return false;
                }
                maxIndex = Math.max(maxIndex, index + nums[index]);
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}