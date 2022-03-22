//给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
//
// 如果反转后整数超过 32 位的有符号整数的范围 [−2³¹, 231 − 1] ，就返回 0。 
//假设环境不允许存储 64 位整数（有符号或无符号）。
//
// 
//
// 示例 1： 
//
// 
//输入：x = 123
//输出：321
// 
//
// 示例 2： 
//
// 
//输入：x = -123
//输出：-321
// 
//
// 示例 3： 
//
// 
//输入：x = 120
//输出：21
// 
//
// 示例 4： 
//
// 
//输入：x = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= x <= 2³¹ - 1 
// 
// Related Topics 数学 👍 3440 👎 0

package leetcode.editor.cn;

public class Q7ReverseInteger {
    public static void main(String[] args) {
        int test = Integer.MAX_VALUE;// 越界
        Solution solution = new Q7ReverseInteger().new Solution();
        System.out.println(solution.reverse(test));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reverse(int x) {
            //boolean negative = ((x>>>31)&1) ==1;
            boolean negative = x < 0 ? true : false;
            // 负数表示的范围比正数表示的范围大一个。
            x = negative ? x : -x;

            int m = Integer.MIN_VALUE / 10;
            int k = Integer.MIN_VALUE % 10;

            int result = 0;

            while (x != 0) {
                if (result < m || (result == m && x % 10 < k)) {
                    return 0;
                }
                result = result * 10 + x % 10;
                x = x / 10;
            }
            return negative ? result : -result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}