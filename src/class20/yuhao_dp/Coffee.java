package class20.yuhao_dp;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 给定一个数组arr[]，arr[i]代表第 i 号咖啡机泡一杯咖啡的时间
 * <p>
 * 给定一个正数 N，表示 N 个人等着咖啡机泡咖啡，每台咖啡机只能轮流泡咖啡
 * <p>
 * 只有一台洗咖啡杯的机器，一次只能洗一个杯子，时间耗费 a，洗完才能洗下一杯
 * <p>
 * 每个咖啡杯也可以自己挥发干净，时间耗费 b，咖啡杯可以并行挥发
 * <p>
 * 假设所有人拿到咖啡之后立刻喝完
 * <p>
 * 求从开始等到所有咖啡杯子变干净的最短时间
 * <p>
 * 参数：int[] arr、 int N， int a、 int b
 */
public class Coffee {


  public static void main(String[] args) {
    int[] arr = new int[]{3, 5, 7, 10};
    int N = 5;

    int a = 1;
    int b = 5;

    Coffee coffee = new Coffee();

    int[] drinks = coffee.calculatorEveryOneGetCoffeeMinTime(arr, N);

    System.out.println(coffee.bestTime(drinks, 0, 0, a, b));
    System.out.println(coffee.bestTimeDP(drinks, a, b));
  }


  private int[] calculatorEveryOneGetCoffeeMinTime(int[] arr, int N) {
    PriorityQueue<Machine> allMachine = new PriorityQueue<>(
        Comparator.comparingInt(o -> (o.timePoint + o.workTime)));

    for (int item : arr) {
      allMachine.add(new Machine(0, item));
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
    int currentCupDoneTime = canWashTime + washCostTime;
    //洗完剩下杯子的时间点
    int restCupDoneTime = bestTime(drinks, index + 1, currentCupDoneTime, washCostTime,
        airCostTime);
    //洗完从 index 开始所有杯子的时间点
    int allCupDoneTime = Math.max(currentCupDoneTime, restCupDoneTime);

    //2、当前杯子决定 - 自然挥发
    int currentCupCleanTime = drinks[index] + airCostTime;
    int restCupCleanTime = bestTime(drinks, index + 1, wishLine, washCostTime, airCostTime);
    int allCupCleanTime = Math.max(currentCupCleanTime, restCupCleanTime);

    return Math.min(allCupDoneTime, allCupCleanTime);
  }


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
        int currentCupDoneTime = canWashTime + washCostTime;

        if (currentCupDoneTime > maxWishLine) {
          continue;
        }

        //洗完剩下杯子的时间点
        int restCupDoneTime = dp[index + 1][currentCupDoneTime];
        //洗完从 index 开始所有杯子的时间点
        int allCupDoneTime = Math.max(currentCupDoneTime, restCupDoneTime);

        //2、当前杯子决定 - 自然挥发
        int currentCupCleanTime = drinks[index] + airCostTime;
        int restCupCleanTime = dp[index + 1][wishLine];
        int allCupCleanTime = Math.max(currentCupCleanTime, restCupCleanTime);

        dp[index][wishLine] = Math.min(allCupDoneTime, allCupCleanTime);
      }
    }
    return dp[0][0];
  }


  private class Machine {

    public int timePoint;//生成出咖啡的时刻
    public int workTime; //生产一杯咖啡的时间

    public Machine(int t, int w) {
      timePoint = t;
      workTime = w;
    }
  }
}
