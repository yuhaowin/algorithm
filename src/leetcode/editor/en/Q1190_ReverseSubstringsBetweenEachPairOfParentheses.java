package leetcode.editor.en;

import java.util.Stack;

public class Q1190_ReverseSubstringsBetweenEachPairOfParentheses {
    public static void main(String[] args) {
        Solution solution = new Q1190_ReverseSubstringsBetweenEachPairOfParentheses().new Solution();
        String s = "(abcd)";
        System.out.println(solution.reverseParentheses(s));
        System.out.println(solution.reverseParentheses2(s));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseParentheses(String inputString) {
            if (inputString == null || inputString == "") {
                return "";
            }
            Stack<String> stack = new Stack<>();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < inputString.length(); i++) {
                char c = inputString.charAt(i);
                if (c == '(') {
                    stack.push(sb.toString());
                    sb = new StringBuilder();
                    continue;
                }
                if (c == ')') {
                    String string = sb.reverse().toString();
                    sb = new StringBuilder(stack.pop() + string);
                    continue;
                }
                sb.append(c);
            }
            return sb.toString();
        }

        //-------------

        public String reverseParentheses1(String inputString) {
            if (inputString == null || inputString == "") {
                return "";
            }
            int startIndex = inputString.lastIndexOf("(");
            int endIndex = inputString.indexOf(")");
            if (startIndex == -1 || endIndex == -1) {
                return inputString;
            }
            String firstPart = inputString.substring(0, startIndex);
            String reversePart = inputString.substring(startIndex + 1, endIndex);
            String endPart = inputString.substring(endIndex + 1, inputString.length());
            System.out.println(firstPart);
            System.out.println(reversePart);
            System.out.println(endPart);
            String result = firstPart + reverse(reversePart) + endPart;
            return reverseParentheses1(result);
        }

        int idx = 0;

        public String reverseParentheses2(String inputString) {
            if (inputString == null || inputString == "") {
                return "";
            }
            String ans = "";
            for (; idx < inputString.length(); ++idx) {
                if (inputString.charAt(idx) == '(') {                        // 左括号，新的递归层
                    ++idx;
                    ans += reverseParentheses2(inputString);        // 字符串拼接，返回的时候idx指向了右括号的位置
                } else if (inputString.charAt(idx) == ')') {
                    ans = reverse(ans);    // 右括号，反转当前层的字符串
                    break;
                } else {
                    ans = ans + inputString.charAt(idx);                // 字母
                }
            }
            return ans;
        }

        private String reverse(String str) {
            if (str == null) {
                return "";
            }
            String reverseStr = new StringBuffer(str).reverse().toString();
            return reverseStr;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}