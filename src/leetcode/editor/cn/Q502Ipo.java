//Suppose LeetCode will start its IPO soon. In order to sell a good price of
//its shares to Venture Capital, LeetCode would like to work on some projects to 
//increase its capital before the IPO. Since it has limited resources, it can only 
//finish at most k distinct projects before the IPO. Help LeetCode design the best 
//way to maximize its total capital after finishing at most k distinct projects. 
//
// You are given n projects where the iᵗʰ project has a pure profit profits[i] 
//and a minimum capital of capital[i] is needed to start it. 
//
// Initially, you have w capital. When you finish a project, you will obtain 
//its pure profit and the profit will be added to your total capital. 
//
// Pick a list of at most k distinct projects from given projects to maximize 
//your final capital, and return the final maximized capital. 
//
// The answer is guaranteed to fit in a 32-bit signed integer. 
//
// 
// Example 1: 
//
// 
//Input: k = 2, w = 0, profits = [1,2,3], capital = [0,1,1]
//Output: 4
//Explanation: Since your initial capital is 0, you can only start the project 
//indexed 0.
//After finishing it you will obtain profit 1 and your capital becomes 1.
//With capital 1, you can either start the project indexed 1 or the project 
//indexed 2.
//Since you can choose at most 2 projects, you need to finish the project 
//indexed 2 to get the maximum capital.
//Therefore, output the final maximized capital, which is 0 + 1 + 3 = 4.
// 
//
// Example 2: 
//
// 
//Input: k = 3, w = 0, profits = [1,2,3], capital = [0,1,2]
//Output: 6
// 
//
// 
// Constraints: 
//
// 
// 1 <= k <= 10⁵ 
// 0 <= w <= 10⁹ 
// n == profits.length 
// n == capital.length 
// 1 <= n <= 10⁵ 
// 0 <= profits[i] <= 10⁴ 
// 0 <= capital[i] <= 10⁹ 
// 
// Related Topics 贪心 数组 排序 堆（优先队列） 👍 227 👎 0

package leetcode.editor.cn;

import java.util.PriorityQueue;

public class Q502Ipo {
    public static void main(String[] args) {
        Solution solution = new Q502Ipo().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
            PriorityQueue<Project> profitQ = new PriorityQueue<>((o1, o2) -> o2.profit - o1.profit);
            PriorityQueue<Project> capitalQ = new PriorityQueue<>((o1, o2) -> o1.capital - o2.capital);

            for (int i = 0; i < capital.length; i++) {
                capitalQ.add(new Project(profits[i], capital[i]));
            }

            for (int i = 0; i < k; i++) {
                while (!capitalQ.isEmpty() && capitalQ.peek().capital <= w) {
                    profitQ.add(capitalQ.poll());
                }
                if (profitQ.isEmpty()) {
                    return w;
                }
                w += profitQ.poll().profit;
            }
            return w;
        }

        class Project {
            int profit;
            int capital;

            public Project(int profit, int capital) {
                this.profit = profit;
                this.capital = capital;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}