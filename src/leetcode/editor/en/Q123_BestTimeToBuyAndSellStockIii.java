package leetcode.editor.en;

public class Q123_BestTimeToBuyAndSellStockIii {
    public static void main(String[] args) {
        Solution solution = new Q123_BestTimeToBuyAndSellStockIii().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length <= 1) {
                return 0;
            }
            int ans = 0;
            int doOnceMinusBudBest = -prices[0];//做完一次交易，并第二次买入后的最好值
            int min = prices[0];
            int doOnceBest = 0; //做完一次交易的最好值
            for (int i = 1; i < prices.length; i++) {
                ans = Math.max(ans, doOnceMinusBudBest + prices[i]);

                min = Math.min(min, prices[i]);
                doOnceBest = Math.max(doOnceBest, prices[i] - min);

                doOnceMinusBudBest = Math.max(doOnceMinusBudBest, doOnceBest - prices[i]);
            }
            return ans;

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}