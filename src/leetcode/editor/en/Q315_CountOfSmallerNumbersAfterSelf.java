package leetcode.editor.en;

import java.util.*;

public class Q315_CountOfSmallerNumbersAfterSelf {
    public static void main(String[] args) {
        Solution solution = new Q315_CountOfSmallerNumbersAfterSelf().new Solution();
        int[] nums = new int[]{0, 2, 1};
        List<Integer> result = solution.countSmaller(nums);
        for (Integer temp : result) {
            System.out.print(temp + " ");
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        Map<Integer, Integer> map = new HashMap<>();

        public List<Integer> countSmaller(int[] nums) {
            return null;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}