package leetcode.editor.en;

/**
 * 垃圾题
 */
public class Q1672RichestCustomerWealth {
    public static void main(String[] args) {
        Solution solution = new Q1672RichestCustomerWealth().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumWealth(int[][] accounts) {
            int max = 0;
            int m = accounts.length;
            int n = accounts[0].length;
            for (int i = 0; i < m; i++) {
                int temp = 0;
                for (int j = 0; j < n; j++) {
                    temp += accounts[i][j];
                }
                max = Math.max(max, temp);
            }
            return max;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}