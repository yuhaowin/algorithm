package leetcode.editor.en;

/**
 * class 6  28:53
 */
public class Q45JumpGameIi {
    public static void main(String[] args) {
        Solution solution = new Q45JumpGameIi().new Solution();
        int[] nums = new int[]{2, 3, 1, 1, 4};
        System.out.println(solution.jump(nums));
        nums = new int[]{2, 0, 2, 0, 1};
        System.out.println(solution.jump(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int jump(int[] nums) {
            if (nums == null || nums.length < 2) {
                return 0;
            }
            int step = 0;
            int curStepMaxIndex = 0; //移动 step 步可以到达的最大位置
            int nextStepMaxIndex = nums[0];// 移动 step+1 步可以到达的最大位置
            for (int index = 1; index < nums.length; index++) {
                if (nextStepMaxIndex >= nums.length - 1) {//优化 提前 return
                    return step + 1;
                }
                if (index > curStepMaxIndex) {
                    step++;
                    curStepMaxIndex = nextStepMaxIndex;
                }
                nextStepMaxIndex = Math.max(nextStepMaxIndex, index + nums[index]);
            }
            return step;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}