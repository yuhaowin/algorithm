//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 动态规划 回溯 👍 2481 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Q22GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new Q22GenerateParentheses().new Solution();
        int n = 2;
        List<String> list = solution.generateParenthesis(n);
        list.stream().forEach(System.out::println);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis(int n) {
            char[] path = new char[n << 1];
            List<String> ans = new ArrayList<>();
            process(path, 0, 0, n, ans);
            return ans;
        }

        public void process(char[] path, int index, int waitMatch, int leftRest, List<String> ans) {
            if (index == path.length) {
                ans.add(String.valueOf(path));
            } else {
                if (waitMatch > 0) {
                    path[index] = ')';
                    process(path, index + 1, waitMatch - 1, leftRest, ans);
                }

                if (leftRest > 0) {
                    path[index] = '(';
                    process(path, index + 1, waitMatch + 1, leftRest - 1, ans);
                }
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}