package leetcode.editor.en;

import java.util.PriorityQueue;

public class Q1094CarPooling {
    public static void main(String[] args) {
        Solution solution = new Q1094CarPooling().new Solution();
        int[][] trips = new int[][]{
                {2, 1, 5},
                {3, 3, 7}
        };
        int capacity = 5;

        trips = new int[][]{
                {10, 1, 6},
                {7, 5, 6},
                {6, 7, 8},
        };
        capacity = 16;
        System.out.println(solution.carPooling(trips, capacity));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean carPooling1(int[][] trips, int capacity) {
            //最先下车
            PriorityQueue<Trip> downQ = new PriorityQueue<>((o1, o2) -> o1.to - o2.to);
            PriorityQueue<Trip> upQ = new PriorityQueue<>((o1, o2) -> o1.form - o2.form);
            int curSize = 0;
            for (int i = 0; i < trips.length; i++) {
                int[] trip = trips[i];
                int num = trip[0];
                int from = trip[1];
                int to = trip[2];
                Trip trip1 = new Trip(num, from, to);
                downQ.add(trip1);
                upQ.add(trip1);
            }
            while (!upQ.isEmpty()) {
                Trip trip = upQ.poll();
                while (downQ.peek().to <= trip.form) {
                    Trip poll = downQ.poll();
                    curSize -= poll.numPassengers;
                }
                curSize += trip.numPassengers;
                if (capacity < curSize) {
                    return false;
                }
            }
            return true;
        }

        public boolean carPooling(int[][] trips, int capacity) {
            int sites[] = new int[1001];
            for (int[] trip : trips) {
                // 上车加
                sites[trip[1]] += trip[0];
                // 下车减
                sites[trip[2]] -= trip[0];
            }
            // 从始发站计数，超过capacity则超载
            int total = 0;
            for (int i : sites) {
                total += i;
                if (total > capacity) {
                    return false;
                }
            }
            return true;
        }
    }

    class Trip {
        int numPassengers;
        int form;
        int to;

        public Trip(int numPassengers, int form, int to) {
            this.numPassengers = numPassengers;
            this.form = form;
            this.to = to;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}