package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Q46Permutations {
    public static void main(String[] args) {
        Solution solution = new Q46Permutations().new Solution();
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> ans = solution.permute(nums);
        ans.stream().forEach(x -> System.out.println(x));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            process(nums, 0, ans);
            return ans;
        }

        private void process(int[] nums, int index, List<List<Integer>> ans) {
            if (index == nums.length) {
                List<Integer> temp = new ArrayList<>();
                for (int num : nums) {
                    temp.add(num);
                }
                ans.add(temp);
                return;
            }
            // 从当前位置到最后，每一个位置都和当前位置换一下
            for (int i = index; i < nums.length; i++) {
                swap(nums, index, i);
                process(nums, index + 1, ans);
                swap(nums, index, i);
            }
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}