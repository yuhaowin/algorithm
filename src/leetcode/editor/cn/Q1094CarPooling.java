//There is a car with capacity empty seats. The vehicle only drives east (i.e., 
//it cannot turn around and drive west). 
//
// You are given the integer capacity and an array trips where trips[i] = [
//numPassengersi, fromi, toi] indicates that the iᵗʰ trip has numPassengersi 
//passengers and the locations to pick them up and drop them off are fromi and toi 
//respectively. The locations are given as the number of kilometers due east from the 
//car's initial location. 
//
// Return true if it is possible to pick up and drop off all passengers for all 
//the given trips, or false otherwise. 
//
// 
// Example 1: 
//
// 
//Input: trips = [[2,1,5],[3,3,7]], capacity = 4
//Output: false
// 
//
// Example 2: 
//
// 
//Input: trips = [[2,1,5],[3,3,7]], capacity = 5
//Output: true
// 
//
// 
// Constraints: 
//
// 
// 1 <= trips.length <= 1000 
// trips[i].length == 3 
// 1 <= numPassengersi <= 100 
// 0 <= fromi < toi <= 1000 
// 1 <= capacity <= 10⁵ 
// 
// Related Topics 数组 前缀和 排序 模拟 堆（优先队列） 👍 160 👎 0

package leetcode.editor.cn;

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