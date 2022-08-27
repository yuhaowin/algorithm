package leetcode.editor.en;

public class Q66_PlusOne {
    public static void main(String[] args) {
        Solution solution = new Q66_PlusOne().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] plusOne(int[] digits) {
            for (int i = digits.length - 1; i >= 0; i--) {
                if (digits[i] < 9) {
                    digits[i]++;
                    return digits;
                }
                digits[i] = 0;
            }
            int[] ans = new int[digits.length + 1];
            ans[0] = 1;
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}