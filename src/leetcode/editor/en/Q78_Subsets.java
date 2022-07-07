package leetcode.editor.en;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q78_Subsets {
    public static void main(String[] args) {
        Solution solution = new Q78_Subsets().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            LinkedList<Integer> path = new LinkedList<>();
            process(nums,0,path,ans);
            return ans;
        }

        private void process(int[] nums, int index, LinkedList<Integer> path,List<List<Integer>> ans){
            if (index == nums.length){
                ans.add(copy(path));
            }else {
                // 1 不要 index 位置的数
                process(nums,index+1,path,ans);
                // 2 要 index 位置的数
                path.add(nums[index] );
                process(nums,index+1,path,ans);
                // 恢复现场
                path.removeLast();
            }
        }

        private List<Integer> copy(List<Integer> path){
            List<Integer> ans = new ArrayList<>();
            for (Integer num : path) {
                ans.add(num);
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}