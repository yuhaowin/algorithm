package leetcode.editor.en;

public class Q122_BestTimeToBuyAndSellStockIi {
    public static void main(String[] args) {
        Solution solution = new Q122_BestTimeToBuyAndSellStockIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length == 0) {
                return 0;
            }
            //收集所有上扬的结果，累加
            int ans = 0;
            for (int i = 1; i < prices.length; i++) {
                ans += Math.max(prices[i] - prices[i - 1], 0);
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}