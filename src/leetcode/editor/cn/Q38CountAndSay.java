package leetcode.editor.cn;

public class Q38CountAndSay {
    public static void main(String[] args) {
        Solution solution = new Q38CountAndSay().new Solution();
        int n = 4;
        System.out.println(solution.countAndSay(n));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String countAndSay(int n) {
            if (n == 1) {
                return "1";
            }

            StringBuilder builder = new StringBuilder();
            char[] preResult = countAndSay(n - 1).toCharArray();

            int count = 1;
            char curChar = preResult[0];
            for (int i = 1; i < preResult.length; i++) {
                if (curChar == preResult[i]) {
                    count++;
                } else {
                    builder.append(count).append(curChar);
                    count = 1;
                    curChar = preResult[i];
                }
            }
            builder.append(count).append(curChar);
            return builder.toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}