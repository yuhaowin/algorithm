package leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

public class Q119_PascalsTriangleIi {
    public static void main(String[] args) {
        Solution solution = new Q119_PascalsTriangleIi().new Solution();
        solution.getRow(3).stream().forEach(System.out::println);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> getRow(int rowIndex) {
            if (rowIndex == 0) {
                return List.of(1);
            }
            if (rowIndex == 1) {
                return List.of(1, 1);
            }
            List<Integer> current = new ArrayList<>();
            List<Integer> previous = getRow(rowIndex - 1);
            for (int i = 0; i <= rowIndex; i++) {
                if (i == 0 || i == rowIndex) {
                    current.add(1);
                } else {
                    current.add(previous.get(i - 1) + previous.get(i));
                }
            }
            return current;
        }

        public List<Integer> getRow1(int rowIndex) {
            List<Integer> previous = new ArrayList<>();
            for (int i = 0; i <= rowIndex; i++) {
                List<Integer> current = new ArrayList<>();
                for (int j = 0; j <= i; j++) {
                    if (j == 0 || j == i) {
                        current.add(1);
                    } else {
                        current.add(previous.get(j - 1) + previous.get(j));
                    }
                }
                previous = current;
            }
            return previous;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}