package leetcode.editor.en;

import java.util.PriorityQueue;

/**
 * 子数组问题
 * 看以每一个 i 结尾的情况，答案都求一遍，然后求 max
 * 组合、子序列问题
 * 求 0-i 范围所有情况，不需要一定以 i 结尾
 */
public class Q53MaximumSubarray {
    public static void main(String[] args) {
        Solution solution = new Q53MaximumSubarray().new Solution();
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(solution.maxSubArray(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubArray0(int[] nums) {
            if (nums.length == 1) {
                return nums[0];
            }
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < nums.length; i++) {
                int temp = 0;
                for (int j = i; j < nums.length; j++) {
                    temp += nums[j];
                    max = Math.max(max, temp);
                }
            }
            return max;
        }

        public int maxSubArray1(int[] nums) {
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            int max = nums[0];
            for (int i = 1; i < nums.length; i++) {
                int p1 = nums[i];
                int p2 = dp[i - 1] + nums[i];
                dp[i] = Math.max(p1, p2);
                max = Math.max(max, dp[i]);
            }
            return max;
        }

        public int maxSubArray2(int[] nums) {
            int temp = nums[0];
            int max = nums[0];
            for (int i = 1; i < nums.length; i++) {
                int p1 = nums[i];
                int p2 = temp + nums[i];
                temp = Math.max(p1, p2);
                max = Math.max(max, temp);
            }
            return max;
        }

        public int maxSubArray(int[] nums) {
            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
            process(nums, nums.length - 1, pq);
            return pq.poll();
        }

        private int process(int[] arr, int end, PriorityQueue<Integer> pq) {
            if (0 == end) {
                pq.add(arr[end]);
                return arr[end];
            }
            int p1 = arr[end];
            int p2 = process(arr, end - 1, pq) + p1;
            pq.add(Math.max(p1, p2));
            return Math.max(p1, p2);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}