package leetcode.editor.cn;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Q506RelativeRanks {
    public static void main(String[] args) {
        Solution solution = new Q506RelativeRanks().new Solution();
        int[] score = new int[]{10, 3, 8, 9, 4};
        String[] result = solution.findRelativeRanks(score);
        Arrays.stream(result).forEach(System.out::println);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String[] findRelativeRanks1(int[] score) {
            String[] ans = new String[score.length];
            Integer[] copy = new Integer[score.length];
            for (int i = 0; i < score.length; i++) {
                copy[i] = score[i];
            }
            Arrays.sort(copy, (a, b) -> b - a);

            for (int s = 0; s < score.length; s++) {
                for (int i = 0; i < copy.length; i++) {
                    if (score[s] == copy[i]) {
                        if (i == 0) {
                            ans[s] = "Gold Medal";
                            continue;
                        }
                        if (i == 1) {
                            ans[s] = "Silver Medal";
                            continue;
                        }
                        if (i == 2) {
                            ans[s] = "Bronze Medal";
                            continue;
                        }
                        ans[s] = String.valueOf(i + 1);
                    }
                }
            }
            return ans;
        }

        public String[] findRelativeRanks(int[] score) {
            PriorityQueue<int[]> queue = new PriorityQueue<>((x, y) -> y[0] - x[0]);
            for (int i = 0; i < score.length; i++) {
                queue.offer(new int[]{score[i], i});
            }
            String[] res = new String[score.length];
            int index = 1;
            while (!queue.isEmpty()) {
                int[] item = queue.poll();
                if (index == 1) {
                    res[item[1]] = "Gold Medal";
                    index++;
                    continue;
                }
                if (index == 2) {
                    res[item[1]] = "Silver Medal";
                    index++;
                    continue;
                }
                if (index == 3) {
                    res[item[1]] = "Bronze Medal";
                    index++;
                    continue;
                }
                res[item[1]] = String.valueOf(index++);
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}