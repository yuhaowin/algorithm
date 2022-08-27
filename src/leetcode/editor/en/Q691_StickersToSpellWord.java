package leetcode.editor.en;

import java.util.HashMap;
import java.util.Map;

public class Q691_StickersToSpellWord {
    public static void main(String[] args) {
        Solution solution = new Q691_StickersToSpellWord().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minStickers(String[] array, String target) {
            int N = array.length;
            //用词频表替代贴纸数组
            int[][] table = new int[N][26];
            for (int i = 0; i < N; i++) {
                char[] temp = array[i].toCharArray();
                for (char ch : temp) {
                    table[i][ch - 'a']++;
                }
            }
            Map<String, Integer> cache = new HashMap<>();
            int ans = recursive(table, target, cache);
            return ans == Integer.MAX_VALUE ? -1 : ans;
        }

        private int recursive(int[][] table, String target, Map<String, Integer> cache) {
            if (target.length() == 0) {
                return 0;
            }
            if (cache.containsKey(target)) {
                return cache.get(target);
            }
            // target 做出词频统计
            int[] targetTable = new int[26];
            char[] targetArr = target.toCharArray();
            for (char cha : targetArr) {
                targetTable[cha - 'a']++;
            }
            int N = table.length;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                // 获取每一种贴纸
                int[] item = table[i];
                // 最关键的优化(重要的剪枝!这一步也是贪心!)
                if (item[targetArr[0] - 'a'] <= 0) {
                    continue;
                }
                StringBuilder builder = new StringBuilder();
                for (int j = 0; j < 26; j++) {
                    if (targetTable[j] > 0) {
                        int nums = targetTable[j] - item[j];
                        for (int k = 0; k < nums; k++) {
                            builder.append((char) (j + 'a'));
                        }
                    }
                }
                String rest = builder.toString();
                min = Math.min(min, recursive(table, rest, cache));
            }
            int ans = min + (min == Integer.MAX_VALUE ? 0 : 1);
            cache.put(target, ans);
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}