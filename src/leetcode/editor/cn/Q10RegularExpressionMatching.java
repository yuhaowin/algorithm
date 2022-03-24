//给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
//
// 
// '.' 匹配任意单个字符 
// '*' 匹配零个或多个前面的那一个元素 
// 
//
// 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。 
// 
//
// 示例 1： 
//
// 
//输入：s = "aa", p = "a"
//输出：false
//解释："a" 无法匹配 "aa" 整个字符串。
// 
//
// 示例 2: 
//
// 
//输入：s = "aa", p = "a*"
//输出：true
//解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
// 
//
// 示例 3： 
//
// 
//输入：s = "ab", p = ".*"
//输出：true
//解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 20 
// 1 <= p.length <= 30 
// s 只包含从 a-z 的小写字母。 
// p 只包含从 a-z 的小写字母，以及字符 . 和 *。 
// 保证每次出现字符 * 时，前面都匹配到有效的字符 
// 
// Related Topics 递归 字符串 动态规划 👍 2840 👎 0

package leetcode.editor.cn;

public class Q10RegularExpressionMatching {
    public static void main(String[] args) {
        Solution solution = new Q10RegularExpressionMatching().new Solution();
        System.out.println(solution.isMatch("bbbba", ".*a*a"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isMatch(String s, String p) {

            if (s == null || p == null) {
                return false;
            }
            char[] str = s.toCharArray();
            char[] pattern = p.toCharArray();

            return process(str, pattern, 0, 0);
        }

        private boolean process(char[] str, char[] pattern, int si, int pi) {
            if (si == str.length) {//表示 str 为 ""
                if (pi == pattern.length) {// pattern 也为 ""
                    return true;
                }

                // ""
                // a*b*c*  ->  ""
                if (pi + 1 < pattern.length && pattern[pi + 1] == '*') {// a* 可以表示为 ""  0个 a
                    return process(str, pattern, si, pi + 2);
                }

                // 上面两种情况都没有中，一个无法匹配
                return false;
            }

            // 如果 pattern 为 "" ，str 必须为 ""
            if (pi == pattern.length) {
                return si == str.length;
            }

            // si 和 pi 都没有到终止位置
            // 1. pi+1 不是*，则 si 和 pi 必须可以对上，后续才有可能对上
            if (pi + 1 >= pattern.length || pattern[pi + 1] != '*') {
                return (str[si] == pattern[pi] || pattern[pi] == '.')
                        && process(str, pattern, si + 1, pi + 1);
            }

            // 2. pi+1 是*
            // 2.1 si 和 pi 对不上
//            if (str[si] != pattern[pi] && pattern[pi] != '.') {
//                return process(str, pattern, si, pi + 2);
//            }
//
//            // 2.2   si 和 pi 对的上
//            // 2.2.1 pi 和 pi+1 --> 为 "" 看后续是否可以搞定
//            if (process(str, pattern, si, pi + 2)) {
//                return true;
//            }
//
//            // 2.2.2
//            while (si < str.length && (str[si] == pattern[pi] || pattern[pi] == '.')) {
//                if (process(str, pattern, si + 1, pi + 2)) {
//                    return true;
//                }
//                si++;
//            }
//
//            return false;

            if ((str[si] == pattern[pi] || pattern[pi] == '.') && process(str, pattern, si + 1, pi)) {
                return true;
            }
            return process(str, pattern, si, pi + 2);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public boolean test(char[] str, char[] pattern, int si, int pi) {
        if (si == str.length) {
            if (pi == pattern.length) {
                return true;
            }

            // a*b*c*....
            if (pi + 1 < pattern.length && pattern[pi + 1] == '*') {
                return test(str, pattern, si, pi + 2);
            }
        }

        if (pi == pattern.length) {
            return si == str.length;
        }


        // si 和 pi 都有后续

        // pi+1 不是 *

        if (pi + 1 >= pattern.length || (pattern[pi + 1] != '*')) {
            return (str[si] == pattern[pi] || pattern[pi] == '.')
                    && test(str, pattern, si + 1, pi + 1);
        }

        // pi+1 是 *

        //对不上
        if (str[si] != pattern[pi] && pattern[pi] != '.') {
            return test(str, pattern, si, pi + 2);
        }

        //对的上

        if (test(str, pattern, si, pi + 2)) {
            return true;
        }


        while (si < str.length && (str[si] == pattern[pi] || pattern[pi] == '.')) {
            if (test(str, pattern, si + 1, pi + 2)) {
                return true;
            }
            si++;
        }

        return false;
    }
}