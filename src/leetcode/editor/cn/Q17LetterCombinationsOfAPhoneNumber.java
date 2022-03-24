//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
// Related Topics 哈希表 字符串 回溯 👍 1797 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Q17LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new Q17LetterCombinationsOfAPhoneNumber().new Solution();

        List<String> strings = solution.letterCombinations("23");
        System.out.println();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> letterCombinations(String digits) {

            if (digits == null || digits.length() == 0) {
                return new ArrayList<>();
            }

            String[][] table = new String[][]{
                    {},
                    {},
                    {"a", "b", "c"},
                    {"d", "e", "f"},
                    {"g", "h", "i"},
                    {"j", "k", "l"},
                    {"m", "n", "o"},
                    {"p", "q", "r", "s"},
                    {"t", "u", "v"},
                    {"w", "x", "y", "z"},
            };

            List<String> ans = new ArrayList<>();

            recursive(digits.toCharArray(), 0, "", table, ans);
            return ans;
        }

        public void recursive(char[] chars, int index, String pre, String[][] table, List<String> ans) {
            if (index == chars.length) {
                ans.add(pre);
                return;
            }

            int i = chars[index] - 48;
            String[] strings = table[i];
            for (String string : strings) {
                recursive(chars, index + 1, pre + string, table, ans);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}