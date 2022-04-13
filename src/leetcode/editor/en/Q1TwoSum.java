package leetcode.editor.en;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q1TwoSum {
    public static void main(String[] args) {
        Solution solution = new Q1TwoSum().new Solution();
        int[] result = solution.twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(result));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int complement = target - nums[i];
                if (map.containsKey(complement)) {
                    return new int[]{map.get(complement), i};
                }
                map.put(nums[i], i);
            }
            throw new IllegalArgumentException("No two sum solution");
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}