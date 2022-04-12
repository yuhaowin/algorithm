package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Q139WordBreak {
    public static void main(String[] args) {
        Solution solution = new Q139WordBreak().new Solution();
        String s = "abcd";
        List<String> strings = Arrays.asList(new String[]{"a", "abc", "b", "cd"});
        System.out.println(solution.wordBreak(s, strings));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            return test(s, wordDict, new HashMap<>());
        }

        public boolean test(String s, List<String> wordDict, HashMap<String, Boolean> cache) {
            if (s == "") {
                return true;
            }
            if (cache.containsKey(s)) {
                return cache.get(s);
            }
            boolean result = false;
            List<String> temp = new ArrayList<>();
            for (String item : wordDict) {
                if (s.startsWith(item)) {
                    temp.add(item);
                }
            }
            for (String s1 : temp) {
                if (result) {
                    break;
                }
                String nes = minus(s, s1);
                result = test(nes, wordDict, cache);
                cache.put(nes, result);
            }
            return result;
        }

        private String minus(String target, String temp) {
            return target.substring(temp.length());
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}