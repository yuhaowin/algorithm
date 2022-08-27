package leetcode.editor.en;

public class Q76_MinimumWindowSubstring {
    public static void main(String[] args) {
        Solution solution = new Q76_MinimumWindowSubstring().new Solution();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(solution.minWindow(s, t));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow(String s, String t) {
            if (s.length() < t.length()) {
                return "";
            }
            char[] source = s.toCharArray();
            char[] target = t.toCharArray();
            int[] table = new int[128];
            for (char c : target) {
                table[c]++;
            }
            //[L,R)
            int L = 0;
            int R = 0;
            int total = target.length;
            //覆盖字符串t开始的位置
            int start = -1;
            int end = -1;
            int windowLength = Integer.MAX_VALUE;
            while (R < source.length) {
                if (table[source[R]]-- > 0) {
                    total--;
                }
                if (total == 0) {
                    while (table[source[L]] < 0) {
                        table[source[L++]]++;
                    }
                    if (windowLength > R - L + 1) {
                        windowLength = R - L + 1;
                        start = L;
                        end = R;
                    }
                    table[source[L++]]++;
                    total++;
                }
                R++;
            }
            return windowLength == Integer.MAX_VALUE ? "" : s.substring(start, end + 1);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}