package leetcode.editor.en;

public class Q121_BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        Solution solution = new Q121_BestTimeToBuyAndSellStock().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length == 0) {
                return 0;
            }
            // i 时间点，包括 i 之前的最小价格
            int min = prices[0];
            int ans = 0;
            // 假设一定要在 i 时间点卖出
            // 求每一个 i 时间的卖出的最好值，整体求一个最大值
            for (int i = 0; i < prices.length; i++) {
                min = Math.min(min, prices[i]);
                ans = Math.max(ans, prices[i] - min);
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}