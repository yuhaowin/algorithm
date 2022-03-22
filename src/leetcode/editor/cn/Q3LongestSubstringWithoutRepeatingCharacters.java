//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 字符串 滑动窗口 👍 7178 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * 子串，子序列，看以 index 位置结尾的情况,把所有情况枚举出来，去 max
 * <p>
 * 例如：子串以 0 位置的结尾最长有多长、1 位置的结尾最长有多长
 */
public class Q3LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String test = "abcabcbb";
        Q3LongestSubstringWithoutRepeatingCharacters q3 = new Q3LongestSubstringWithoutRepeatingCharacters();
        Solution solution = new Q3LongestSubstringWithoutRepeatingCharacters().new Solution();
        System.out.println(solution.lengthOfLongestSubstring(test));
        System.out.println(q3.lengthOfLongestSubstring(test));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            char[] chars = s.toCharArray();
            int preIndex = 0;
            // 最终的结果
            int result = 0;
            Map<Character, Integer> cache = new HashMap<>();
            for (int index = 0; index < s.length(); index++) {
                char currentChar = chars[index];
                // 当前字符的前一个下标
                Integer lastIndex = cache.get(currentChar);
                if (lastIndex != null) {
                    // 如果当前字符的前一个下标存在
                    // 那么当前字符距离不重复字符的最远的下标是：index-1 的最远下标和上一个当前字符串下标的 pk 近的那一个。
                    preIndex = Math.max(preIndex, lastIndex + 1);
                }
                int currentLength = index - preIndex + 1;
                result = Math.max(result, currentLength);
                cache.put(currentChar, index);
            }
            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int[] map = new int[256];
        for (int i = 0; i < map.length; i++) {
            map[i] = -1;
        }
        int preIndex = 0;
        int result = 0;
        for (int index = 0; index < chars.length; index++) {
            int lastIndex = map[chars[index]];
            preIndex = Math.max(preIndex, lastIndex + 1);
            int currentLength = index - preIndex + 1;
            result = Math.max(result, currentLength);
            map[chars[index]] = index;
        }
        return result;
    }
}