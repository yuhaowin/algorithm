package leetcode.editor.en;

import java.util.*;

public class Q2248_IntersectionOfMultipleArrays {
    public static void main(String[] args) {
        Solution solution = new Q2248_IntersectionOfMultipleArrays().new Solution();
        int[][] nums = new int[][]{
                {3, 1, 2, 4, 5}
                , {1, 2, 3, 4}
                , {3, 4, 5, 6}
        };
        solution.intersection(nums).stream().forEach(i -> System.out.print(i + " "));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> intersection(int[][] nums) {
            List<Integer> list = new ArrayList<>();
            int[] arr = new int[1001];
            for (int[] num : nums) {
                for (int n : num) arr[n]++;
            }
            for (int i = 1; i < 1001; i++) {
                if (arr[i] == nums.length) list.add(i);
            }
            return list;
        }

        //--------------------------------------------------------------------------------------------------------------

        public List<Integer> intersection1(int[][] nums) {
            int N = nums.length;
            Map<Integer, Integer> map = new HashMap<>();
            for (int[] num : nums) {
                for (int temp : num) {
                    map.put(temp, map.getOrDefault(temp, 0) + 1);
                }
            }
            List<Integer> ans = new ArrayList<>();
            for (Map.Entry<Integer, Integer> item : map.entrySet()) {
                if (item.getValue() == N) {
                    ans.add(item.getKey());
                }
            }
            Collections.sort(ans);
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}