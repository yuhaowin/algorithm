package leetcode.editor.en;

public class Q7ReverseInteger {
    public static void main(String[] args) {
        Solution solution = new Q7ReverseInteger().new Solution();
        int x = 1002;
        System.out.println(solution.reverse(x));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reverse(int x) {
            //boolean negative = ((x>>>31)&1) ==1;
            boolean negative = x < 0 ? true : false;
            // 负数表示的范围比正数表示的范围大一个。
            x = negative ? x : -x;

            int result = 0;
            int m = Integer.MIN_VALUE / 10;
            int k = Integer.MIN_VALUE % 10;
            while (x != 0) {
                if (result < m || (result == m && x % 10 < k)) {
                    return 0; //如果 result < m 那 result * 10 一定越界，越界返回 0。
                }
                result = result * 10 + x % 10;
                x = x / 10;
            }
            return negative ? result : -result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}