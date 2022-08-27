package leetcode.editor.en;

import java.util.*;

public class Q49_GroupAnagrams {
    public static void main(String[] args) {
        Solution solution = new Q49_GroupAnagrams().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            List<List<String>> result = new ArrayList<>();
            Map<String, List<String>> cache = new HashMap<>();
            for (String str : strs) {
                char[] chars = str.toCharArray();
                Arrays.sort(chars);
                String key = new String(chars);
                if (cache.containsKey(key)) {
                    cache.get(key).add(str);
                } else {
                    List<String> item = new ArrayList<>();
                    item.add(str);
                    cache.put(key, item);
                }
            }
            for (List<String> value : cache.values()) {
                result.add(value);
            }
            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}