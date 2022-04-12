package leetcode.editor.cn;

public class Q26RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        Solution solution = new Q26RemoveDuplicatesFromSortedArray().new Solution();
        int[] nums = new int[]{1, 1, 2};
        System.out.println(solution.removeDuplicates(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int removeDuplicates(int[] nums) {
            if (nums == null) {
                return 0;
            }
            if (nums.length < 2) {
                return nums.length;
            }
            int down = 0;
            for (int i = 1; i < nums.length; i++) {
                if (nums[down] != nums[i]) {
                    nums[++down] = nums[i];
                }
            }
            return down + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}