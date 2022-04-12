package leetcode.editor.cn;

/**
 * 将数组一分为二，其中一定有一个是有序的，另一个可能是有序，也能是部分有序。
 * 此时有序部分用二分法查找。无序部分再一分为二，其中一个一定有序，另一个可能有序，可能无序。就这样循环.
 */
public class Q33SearchInRotatedSortedArray {
    public static void main(String[] args) {
        Solution solution = new Q33SearchInRotatedSortedArray().new Solution();
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println(solution.search(nums, target));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {
            if (nums.length == 0) {
                return -1;
            }
            if (nums.length == 1) {
                return nums[0] == target ? 0 : -1;
            }
            int n = nums.length;
            int L = 0;
            int R = n - 1;

            while (L <= R) {
                int M = (L + R) / 2;
                if (nums[M] == target) {
                    return M;
                }
                if (nums[L] <= nums[M]) {
                    if (nums[L] <= target && target < nums[M]) {
                        R = M - 1;
                    } else {
                        L = M + 1;
                    }
                } else {
                    if (nums[M] < target && target <= nums[R]) {
                        L = M + 1;
                    } else {
                        R = M - 1;
                    }
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}