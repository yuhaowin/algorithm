package leetcode.editor.en;

public class Q667_BeautifulArrangementIi {
    public static void main(String[] args) {
        Solution solution = new Q667_BeautifulArrangementIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] constructArray(int n, int k) {
            int[] ans = new int[n];
            ans[0] = 1;
            for (int i = 1; i < n; i++) {
                int temp = ans[i - 1] + k;
                if (temp > n) {

                }
            }
            return null;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}