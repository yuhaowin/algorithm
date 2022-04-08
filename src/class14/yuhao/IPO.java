package class14.yuhao;

import java.util.PriorityQueue;

/**
 * 输入：正数数组 costs、正数数组 profits、正数 K、正数 M
 * costsn 表示 1 号项目的花费
 * profits 0 表示 i 号项目在扣除花费之后还能挣到的钱(利润）
 * K 表示你只能串行的最多做 k 个项目
 * M 表示你初始的资金
 * 说明：每做完一个项目，马上获得的收益，可以支持你去做下一个项目。不能并行的做项目。
 * 输出：你最后获得的最大钱数。
 */
public class IPO {

    public static void main(String[] args) {
        IPO ipo = new IPO();
    }

    public int findMaximizedCapital(int K, int W, int[] Profits, int[] Capital) {
        PriorityQueue<Program> minCostQ = new PriorityQueue<>((o1, o2) -> o1.c - o2.c);
        PriorityQueue<Program> maxProfitQ = new PriorityQueue<>((o1, o2) -> o2.p - o1.p);

        //准备所有的 program
        for (int i = 0; i < Profits.length; i++) {
            minCostQ.add(new Program(Profits[i], Capital[i]));
        }

        for (int i = 0; i < K; i++) {
            while (!minCostQ.isEmpty() && minCostQ.peek().c <= W) {
                maxProfitQ.add(minCostQ.poll());
            }
            if (maxProfitQ.isEmpty()) {
                return W;
            }
            W += maxProfitQ.poll().p;
        }
        return W;
    }

    //------------------------------------------------------------------------------------------------------------------

    static class Program {
        public int p;
        public int c;

        public Program(int p, int c) {
            this.p = p;
            this.c = c;
        }
    }
}
