package leetcode.editor.en;

public class Q91_DecodeWays {
    public static void main(String[] args) {
        Solution solution = new Q91_DecodeWays().new Solution();
        String str = "226";
        System.out.println(solution.numDecodings0(str));
        System.out.println(solution.numDecodings(str));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numDecodings0(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }
            char[] array = s.toCharArray();
            return process(array, 0);
        }

        private int process(char[] array, int index) {
            if (index == array.length) {
                return 1;
            }
            if (array[index] == '0') {
                return 0;
            }

            int way1 = process(array, index + 1);
            if (index + 1 == array.length) {
                return way1;
            }
            int temp = (array[index] - '0') * 10 + (array[index + 1] - '0');
            if (temp > 26) {
                return way1;
            }
            int way2 = process(array, index + 2);

            return way1 + way2;
        }

        //--------------------------------------------------------------------------------------------------------------

        public int numDecodings(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }
            char[] array = s.toCharArray();
            return dp(array);
        }

        private int dp(char[] array) {
            int N = array.length;
            int[] dp = new int[N + 1];
            dp[N] = 1;

            for (int index = N - 1; index >= 0; index--) {
                if (array[index] == '0') {
                    dp[index] = 0;
                    continue;
                }

                int way1 = dp[index + 1];
                if (index + 1 == array.length) {
                    dp[index] = way1;
                    continue;
                }
                int temp = (array[index] - '0') * 10 + (array[index + 1] - '0');
                if (temp > 26) {
                    dp[index] = way1;
                    continue;
                }
                int way2 = dp[index + 2];
                dp[index] = way1 + way2;
            }

            return dp[0];
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)
}