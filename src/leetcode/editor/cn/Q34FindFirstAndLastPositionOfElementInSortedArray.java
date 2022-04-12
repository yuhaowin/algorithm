package leetcode.editor.cn;

/**
 * 在一个升序数组中，找个大于等于 x 最左的位置，和找到小于等于 x 最右的位置。使用二分法。
 */
public class Q34FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new Q34FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        int[] nums = new int[]{1, 2, 3, 4, 5, 5, 6, 7};
        System.out.println(solution.searchRange(nums, 5));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int L = 0;
            int R = nums.length - 1;
            int minimumIndex = -1;
            int maximumIndex = -1;

            while (L <= R) {
                int M = (L + R) / 2;
                if (target <= nums[M]) {
                    if (target == nums[M]) {
                        minimumIndex = M;
                    }
                    R = M - 1;
                } else {
                    L = M + 1;
                }
            }

            L = 0;
            R = nums.length - 1;
            while (L <= R) {
                int M = (L + R) / 2;
                if (target >= nums[M]) {
                    if (target == nums[M]) {
                        maximumIndex = M;
                    }
                    L = M + 1;
                } else {
                    R = M - 1;
                }
            }
            return new int[]{minimumIndex, maximumIndex};
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}