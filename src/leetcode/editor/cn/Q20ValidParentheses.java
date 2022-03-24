//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 👍 3116 👎 0

package leetcode.editor.cn;

import java.util.Stack;

public class Q20ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new Q20ValidParentheses().new Solution();

        String test = "{[]}";
        test = "()[]{}";
        test = "([)]";
        test = "(";
        test = "}";
        System.out.println(solution.isValid(test));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            char[] chars = s.toCharArray();
            Stack<Character> temp = new Stack<>();
            for (char c : chars) {
                if (c == '(' || c == '{' || c == '[') {
                    temp.push(c);
                }
                if (c == ')' || c == '}' || c == ']') {
                    if (temp.empty()) {
                        return false;
                    }
                    Character pop = temp.pop();
                    if (c == ')' && pop != '(') {
                        return false;
                    }
                    if (c == '}' && pop != '{') {
                        return false;
                    }
                    if (c == ']' && pop != '[') {
                        return false;
                    }
                }
            }

            if (!temp.empty()) {
                return false;
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}