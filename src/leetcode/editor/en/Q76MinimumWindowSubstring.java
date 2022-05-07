package leetcode.editor.en;

public class Q76MinimumWindowSubstring {
    public static void main(String[] args) {
        Solution solution = new Q76MinimumWindowSubstring().new Solution();
        String s = "a";
        String t = "b";
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
            int[] table = new int[256];
            for (char c : target) {
                table[c]++;
            }
            //[L,R)
            int L = 0;
            int R = 0;

            int LL = -1;
            int RR = -1;
            int min = -1;
            int total = target.length;

            while (R < source.length) {
                table[source[R]]--;
                if (table[source[R]] >= 0) {
                    total--;
                }
                if (total == 0) {
                    while (table[source[L]] < 0) {
                        table[source[L++]]++;
                    }
                    if (min == -1 || min > R - L + 1) {
                        min = R - L + 1;
                        LL = L;
                        RR = R;
                    }
                    table[source[L++]]++;
                    total++;
                }
                R++;
            }
            return min == -1 ? "" : s.substring(LL, RR + 1);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}