package leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

public class Q118_PascalsTriangle {
    public static void main(String[] args) {
        Solution solution = new Q118_PascalsTriangle().new Solution();
        int numRows = 5;
        List<List<Integer>> result = solution.generate(numRows);
        for (List<Integer> item : result) {
            item.stream().forEach(i -> System.out.print(i + " "));
            System.out.println();
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            if (numRows == 1) {
                List<List<Integer>> result = new ArrayList<>();
                ArrayList<Integer> list = new ArrayList<>();
                list.add(1);
                result.add(list);
                return result;
            }
            List<List<Integer>> previous = generate(numRows - 1);
            List<Integer> item = previous.get(numRows - 2);
            ArrayList<Integer> current = new ArrayList<>();
            for (int i = 0; i <= numRows - 1; i++) {
                if (i == 0 || i == numRows - 1) {
                    current.add(1);
                } else {
                    current.add(item.get(i - 1) + item.get(i));
                }
            }
            previous.add(current);
            return previous;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}