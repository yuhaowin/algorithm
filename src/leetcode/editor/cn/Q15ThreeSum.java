//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
// Related Topics 数组 双指针 排序 👍 4523 👎 0

package leetcode.editor.cn;

import java.util.*;

public class Q15ThreeSum {
    public static void main(String[] args) {
        Solution solution = new Q15ThreeSum().new Solution();
        int[] test = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = solution.threeSum(test);
        //List<List<Integer>> lists = solution.twoSum(test, -2);
        System.out.println();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            if (nums == null || nums.length == 0) {
                return new ArrayList<>();
            }
            Arrays.sort(nums);
            List<List<Integer>> result = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                int temp = nums[i];
                int twosum = 0 - temp;

                if (i !=0 && nums[i-1] == nums[i]){
                    continue;
                }

                List<List<Integer>> lists = twoSum(nums, i + 1, twosum);
                if (!lists.isEmpty()) {
                    lists.stream().forEach(it -> it.add(temp));
                    result.addAll(lists);
                }
            }
            return result;
        }

        public List<List<Integer>> twoSum(int[] nums, int index, int target) {
            int L = index;
            int R = nums.length - 1;
            List<List<Integer>> result = new ArrayList<>();

            while (L < R) {

                if (nums[L] + nums[R] < target) {
                    L++;
                    continue;
                }

                if (nums[L] + nums[R] > target) {
                    R--;
                    continue;
                }

                if (nums[L] + nums[R] == target) {
                    if (L == index || nums[L - 1] != nums[L]) {
                        List<Integer> t = new ArrayList<>();
                        t.add(nums[L]);
                        t.add(nums[R]);
                        result.add(t);
                    }
                    L++;
                    R--;
                    continue;
                }
            }
            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}