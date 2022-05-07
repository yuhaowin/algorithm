package leetcode.editor.en;

public class Q283MoveZeroes {
    public static void main(String[] args) {
        Solution solution = new Q283MoveZeroes().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void moveZeroes(int[] nums) {
            int x = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    swap(nums, i, x++);
                }
            }
        }

        public void swap(int[] nums, int left, int right) {
            if (left == right) {
                return;
            }
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}