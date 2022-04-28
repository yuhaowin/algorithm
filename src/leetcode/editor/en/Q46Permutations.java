package leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

public class Q46Permutations {
    public static void main(String[] args) {
        Solution solution = new Q46Permutations().new Solution();
        int[] nums = new int[]{1, 2, 3};
        solution.permute(nums).stream().forEach((item) -> System.out.println(item.toString()));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            recursive(nums, 0, result);
            return result;
        }

        private void recursive(int[] nums, int index, List<List<Integer>> result) {
            if (index == nums.length) {
                List<Integer> item = new ArrayList<>();
                for (int num : nums) {
                    item.add(num);
                }
                result.add(item);
                return;
            }
            for (int i = index; i < nums.length; i++) {
                swap(nums, i, index);
                recursive(nums, index + 1, result);
                swap(nums, i, index);
            }
        }

        private void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}