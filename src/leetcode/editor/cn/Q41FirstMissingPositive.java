package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class Q41FirstMissingPositive {
    public static void main(String[] args) {
        Solution solution = new Q41FirstMissingPositive().new Solution();
        int[] nums = new int[]{1, 2, 0};
        nums = new int[]{3, 4, -1, 1};
        nums = new int[]{7, 8, 9, 11, 12};
        nums = new int[]{1, 2, 3, 4};
        nums = new int[]{3, 4, -1, 1};
        System.out.println(solution.firstMissingPositive(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int firstMissingPositive1(int[] nums) {
            Set<Integer> temp = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                temp.add(nums[i]);
            }

            for (int i = 1; i <= nums.length + 1; i++) {
                if (!temp.contains(i)) {
                    return i;
                }
            }
            return -1;
        }

        public int firstMissingPositive(int[] nums) {
            boolean flag = false;
            int length = nums.length;

            for (int i = 0; i < length; i++) {
                if (nums[i] <= 0) {
                    nums[i] = length + 1;
                }
            }

            for (int i = 0; i < length; ++i) {
                int num = Math.abs(nums[i]);
                if (num <= length) {
                    nums[num - 1] = -Math.abs(nums[num - 1]);
                }
            }

            for (int i = 0; i < length; ++i) {
                if (nums[i] > 0) {
                    return i + 1;
                }
            }
            return length + 1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}