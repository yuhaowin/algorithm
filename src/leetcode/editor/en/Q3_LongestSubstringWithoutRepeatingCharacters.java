package leetcode.editor.en;

import java.util.HashMap;
import java.util.Map;

/**
 * 子串，子序列，看以 index 位置结尾的情况,把所有情况枚举出来，取 max
 * 例如：子串以 0 位置的结尾最长有多长、1 位置的结尾最长有多长
 * ---------------------------------------------------------------------------------------------------------------------
 * 求 i 位置的字符串往左推，看看最远可以推到哪里？
 * 往左推的限制有两个
 * 1、i 位置对应字符串上一次出现的位置
 * 2、i-1 位置对应的字符串推到的位置，因为如果超过这个位置，那 i-1 位置的字符串就重复了。
 * 求 2 个 index 大的那一个作为本次的最左的位置。
 */
public class Q3_LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new Q3_LongestSubstringWithoutRepeatingCharacters().new Solution();
        String s = "abba";
        System.out.println(solution.lengthOfLongestSubstring(s));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int max = 0;
            int startIndex = 0;
            char[] chars = s.toCharArray();
            Map<Character, Integer> map = new HashMap<>();
            for (int index = 0; index < chars.length; index++) {
                char ch = chars[index];
                Integer lastIndex = map.get(ch);
                if (lastIndex != null) {
                    //上一轮 startIndex 表示的是上一个字符结尾的开始位置,
                    //那当前字符的开始位置一定是要大于等于上一个字符串的 startIndex 位置的。
                    //如: "abba"
                    startIndex = Math.max(startIndex, lastIndex + 1);
                }
                int currentLength = index - startIndex + 1;
                max = Math.max(max, currentLength);
                map.put(ch, index);
            }
            return max;
        }

        //--------------------------------------------------------------------------------------------------------------

        public int lengthOfLongestSubstring1(String s) {
            char[] chars = s.toCharArray();
            int[] map = new int[256];
            for (int i = 0; i < map.length; i++) {
                map[i] = -1;
            }
            int result = 0;
            int startIndex = 0;
            for (int index = 0; index < chars.length; index++) {
                int lastIndex = map[chars[index]];
                startIndex = Math.max(startIndex, lastIndex + 1);
                int currentLength = index - startIndex + 1;
                result = Math.max(result, currentLength);
                map[chars[index]] = index;
            }
            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}