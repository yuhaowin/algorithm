package leetcode.editor.en;

import java.util.PriorityQueue;

/**
 * 最后石头的重量
 */
public class Q1046_LastStoneWeight {
    public static void main(String[] args) {
        Solution solution = new Q1046_LastStoneWeight().new Solution();
        int[] stones = new int[]{2, 7, 4, 1, 8, 1};
        System.out.println(solution.lastStoneWeight(stones) == 1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lastStoneWeight(int[] stones) {
            PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
            for (int stone : stones) {
                queue.offer(stone);
            }
            while (queue.size() >= 2) {
                Integer y = queue.poll();
                Integer x = queue.poll();
                if (y != x) {
                    queue.offer(y - x);
                }
            }
            return queue.isEmpty() ? 0 : queue.poll();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}