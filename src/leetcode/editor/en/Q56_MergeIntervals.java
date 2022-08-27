package leetcode.editor.en;

import java.util.*;

public class Q56_MergeIntervals {
    public static void main(String[] args) {
        Solution solution = new Q56_MergeIntervals().new Solution();
        int[][] nums = new int[][]{
                {1, 3}, {2, 6}, {8, 10}, {15, 18}
        };
        solution.merge(nums);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] merge(int[][] intervals) {
            int size = intervals.length;
            Record[] records = new Record[size];
            for (int i = 0; i < size; i++) {
                records[i] = new Record(intervals[i][0], intervals[i][1]);
            }
            Arrays.sort(records, Comparator.comparingInt(a -> a.start));

            int end = records[0].end;
            int start = records[0].start;
            List<Record> ans = new ArrayList<>();
            for (int i = 1; i < size; i++) {
                Record record = records[i];
                if (end < record.start) {
                    ans.add(new Record(start, end));
                    start = record.start;
                }
                end = Math.max(end, record.end);
            }
            ans.add(new Record(start, end));

            int[][] res = new int[ans.size()][2];
            for (int i = 0; i < ans.size(); i++) {
                Record record = ans.get(i);
                res[i] = new int[]{record.start, record.end};
            }
            return res;
        }
    }

    class Record {
        public int start;
        public int end;

        public Record(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}