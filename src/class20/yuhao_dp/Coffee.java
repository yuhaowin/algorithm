package class20.yuhao_dp;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 给定一个数组 machine[],machine[i]代表第 i 号咖啡机泡一杯咖啡的时间
 * 给定一个正数 N,表示 N 个人等着咖啡机泡咖啡，每台咖啡机只能轮流泡咖啡
 * 只有一台洗咖啡杯的机器，一次只能洗一个杯子，时间耗费 washCostTime，洗完才能洗下一杯子
 * 每个咖啡杯也可以自己挥发干净，时间耗费 airCostTime，咖啡杯可以并行挥发
 * 假设所有人拿到咖啡之后立刻喝完
 * 求从开始等到所有咖啡杯变干净的最短时间
 * 参数：int[] machine、 int N， int washCostTime、 int airCostTime
 */
public class Coffee {

    public static void main(String[] args) {
        int N = 30;
        int airCostTime = 5;
        int washCostTime = 1;
        int[] machine = new int[]{3, 5, 7, 10};

        Coffee coffee = new Coffee();
        //依次得到 N 个待处理咖啡杯的时间点
        int[] drinks = coffee.calculateEveryoneGetCoffeeMinTime(machine, N);

        long start = System.currentTimeMillis();
        System.out.println(String.format("result: %s,cost: %s ms", coffee.bestTime(drinks, 0, 0, washCostTime, airCostTime), System.currentTimeMillis() - start));
        start = System.currentTimeMillis();
        System.out.println(String.format("result: %s,cost: %s ms", coffee.bestTimeDP(drinks, washCostTime, airCostTime), System.currentTimeMillis() - start));
    }

    /**
     * @param drinks
     * @param index
     * @param wishLine     洗杯子的机器何时可以使用
     * @param washCostTime 洗一个杯子使用的时间
     * @param airCostTime  挥发一个杯子使用的时间
     * @return 返回所有杯子变干净的最早时间点
     */
    private int bestTime(int[] drinks, int index, int wishLine, int washCostTime, int airCostTime) {
        if (index == drinks.length) {
            return 0;
        }
        //1、当前杯子决定 - 洗
        //可以洗 index 号杯子的时间点
        int canWashTime = Math.max(drinks[index], wishLine);
        //洗完 index 号杯子的时间点
        int currentCupWashDoneTime = canWashTime + washCostTime;
        //洗完剩下杯子的时间点
        int restCupDoneTime = bestTime(drinks, index + 1, currentCupWashDoneTime, washCostTime, airCostTime);
        //洗完从 index 开始所有杯子的时间点
        int p1 = Math.max(currentCupWashDoneTime, restCupDoneTime);

        //2、当前杯子决定 - 自然挥发
        int currentCupAirDoneTime = drinks[index] + airCostTime;
        int restCupCleanTime = bestTime(drinks, index + 1, wishLine, washCostTime, airCostTime);
        int p2 = Math.max(currentCupAirDoneTime, restCupCleanTime);

        return Math.min(p1, p2);
    }

    //------------------------------------------------------------------------------------------------------------------

    private int bestTimeDP(int[] drinks, int washCostTime, int airCostTime) {
        int maxWishLine = 0;
        for (int i = 0; i < drinks.length; i++) {
            maxWishLine = Math.max(drinks[i], maxWishLine) + washCostTime;
        }
        int N = drinks.length;
        int[][] dp = new int[N + 1][maxWishLine + 1];

        for (int index = N - 1; index >= 0; index--) {
            for (int wishLine = 0; wishLine <= maxWishLine; wishLine++) {
                //1、当前杯子决定 - 洗
                //可以洗 index 号杯子的时间点
                int canWashTime = Math.max(drinks[index], wishLine);
                //洗完 index 号杯子的时间点
                int currentCupWashDoneTime = canWashTime + washCostTime;
                if (currentCupWashDoneTime > maxWishLine) {
                    continue; //不存在这种情况。
                }
                //洗完剩下杯子的时间点
                int restCupDoneTime = dp[index + 1][currentCupWashDoneTime];
                //洗完从 index 开始所有杯子的时间点
                int p1 = Math.max(currentCupWashDoneTime, restCupDoneTime);

                //2、当前杯子决定 - 自然挥发
                int currentCupAirDoneTime = drinks[index] + airCostTime;
                int restCupCleanTime = dp[index + 1][wishLine];
                int p2 = Math.max(currentCupAirDoneTime, restCupCleanTime);

                dp[index][wishLine] = Math.min(p1, p2);
            }
        }
        return dp[0][0];
    }

    //------------------------------------------------------------------------------------------------------------------

    private int[] calculateEveryoneGetCoffeeMinTime(int[] machineArray, int N) {
        PriorityQueue<Machine> allMachine = new PriorityQueue<>(Comparator.comparingInt(o -> (o.timePoint + o.workTime)));
        for (int workTime : machineArray) {
            allMachine.add(new Machine(0, workTime));
        }
        int[] drinks = new int[N];
        for (int i = 0; i < N; i++) {
            Machine machine = allMachine.poll();
            drinks[i] = machine.timePoint + machine.workTime;
            machine.timePoint += machine.workTime;
            allMachine.add(machine);
        }
        return drinks;
    }

    private class Machine {
        //生成出咖啡的时刻
        public int timePoint;
        //生产一杯咖啡的时间
        public int workTime;

        public Machine(int timePoint, int workTime) {
            this.timePoint = timePoint;
            this.workTime = workTime;
        }
    }
}
