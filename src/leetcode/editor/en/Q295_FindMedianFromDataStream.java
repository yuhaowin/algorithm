package leetcode.editor.en;

import java.util.PriorityQueue;
import java.util.Queue;

public class Q295_FindMedianFromDataStream {
    public static void main(String[] args) {
        MedianFinder solution = new Q295_FindMedianFromDataStream().new MedianFinder();
        solution.addNum(1);
        solution.addNum(2);
        solution.addNum(3);
        solution.addNum(4);
        solution.addNum(5);
        System.out.println(solution.findMedian());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MedianFinder {

        public MedianFinder() {
        }

        private Queue<Integer> minQueue = new PriorityQueue<>((a1, a2) -> a1 - a2);
        private Queue<Integer> maxQueue = new PriorityQueue<>((a1, a2) -> a2 - a1);

        public void addNum(int num) {
            minQueue.add(num);
            maxQueue.add(minQueue.poll());
            if (maxQueue.size() > minQueue.size()) {
                minQueue.add(maxQueue.poll());
            }

        }

        public double findMedian() {
            if (maxQueue.size() == minQueue.size())
                return (minQueue.peek() + maxQueue.peek()) / 2.0;
            else
                return minQueue.peek();
        }
    }

    /**
     * Your MedianFinder object will be instantiated and called as such:
     * MedianFinder obj = new MedianFinder();
     * obj.addNum(num);
     * double param_2 = obj.findMedian();
     */
    //leetcode submit region end(Prohibit modification and deletion)
}