package leetcode.editor.en;

public class Q344ReverseString {
    public static void main(String[] args) {
        Solution solution = new Q344ReverseString().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void reverseString(char[] chars) {
            int L = 0;
            int R = chars.length - 1;
            while (L < R) {
                swap(chars, L++, R--);
            }
        }

        private void swap(char[] chars, int i, int j) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}