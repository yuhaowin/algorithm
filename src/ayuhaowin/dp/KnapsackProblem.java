package ayuhaowin.dp;

/**
 * 01背包问题（01 knapsack problem）：
 * <p>
 * 一共有N件物品，第i（i从1开始）件物品的重量为w[i]，价值为v[i]。在总重量不超过背包承载上限W的情况下，能够装入背包的最大价值是多少？
 */
public class KnapsackProblem {

  public static void main(String[] args) {
    int[] weight = {7, 6, 4};
    int[] value = {14, 11, 7};
    int bagSize = 12;
    KnapsackProblem knapsackProblem = new KnapsackProblem();
    System.out.println(knapsackProblem.process(0, bagSize, weight, value));
    System.out.println(knapsackProblem.f(3, bagSize, weight, value));

    int[][] cache = new int[weight.length + 1][bagSize + 1];
    for (int i = 0; i < weight.length + 1; i++) {
      for (int j = 0; j < bagSize + 1; j++) {
        cache[i][j] = -1;
      }
    }
    System.out.println(knapsackProblem.process1(0, bagSize, weight, value, cache));
    knapsackProblem.testweightbagproblem(weight,value,bagSize);
  }

  private int process(int cur, int restWeight, int[] weight, int[] value) {
    if (cur == weight.length || restWeight == 0) {
      return 0;
    }
    if (weight[cur] > restWeight) {
      return process(cur + 1, restWeight, weight, value);
    }
    int temp1 = process(cur + 1, restWeight, weight, value);
    int temp2 = process(cur + 1, restWeight - weight[cur], weight, value) + value[cur];
    return Math.max(temp1, temp2);
  }

  private int process1(int cur, int restWeight, int[] weight, int[] value, int[][] cache) {
    if (cur == weight.length || restWeight == 0) {
      return 0;
    }

    if (weight[cur] > restWeight) {
      int temp1 = 0;
      if (cache[cur + 1][restWeight] != -1) {
        temp1 = cache[cur + 1][restWeight];
      } else {
        temp1 = process1(cur + 1, restWeight, weight, value, cache);
      }
      cache[cur][restWeight] = temp1;
      return temp1;
    }

    int temp1 = 0;
    if (cache[cur + 1][restWeight] != -1) {
      temp1 = cache[cur + 1][restWeight];
    } else {
      temp1 = process1(cur + 1, restWeight, weight, value, cache);
    }

    int temp2 = 0;
    if (cache[cur + 1][restWeight - weight[cur]] != -1) {
      temp2 = cache[cur + 1][restWeight - weight[cur]];
    } else {
      temp2 = process1(cur + 1, restWeight - weight[cur], weight, value, cache) + value[cur];
    }
    int result = Math.max(temp1, temp2);
    cache[cur][restWeight] = result;
    return result;
  }

  //--------------------------------------------------------


  private int process2(int restWeight, int[] weight, int[] value) {
    int[][] cache = new int[weight.length + 1][restWeight + 1];

    for (int i = 0; i <= weight.length; i++) {

      for (int j = 0; j <= restWeight; j++) {
        if (weight[i] > restWeight) {
          cache[i][restWeight] = cache[i + 1][restWeight];
        } else {
          int p1 = cache[i + 1][restWeight];
          int p2 = cache[i + 1][restWeight - weight[i]] + value[i];
          cache[i][restWeight] = Math.max(p1, p2);
        }
      }

    }
    return 1;
  }

  public void testweightbagproblem(int[] weight, int[] value, int bagsize) {
    int wlen = weight.length, value0 = 0;
    //定义dp数组：dp[i][j]表示背包容量为j时，前i个物品能获得的最大价值
    int[][] dp = new int[wlen + 1][bagsize + 1];
    //初始化：背包容量为0时，能获得的价值都为0
    for (int i = 0; i <= wlen; i++) {
      dp[i][0] = value0;
    }
    //遍历顺序：先遍历物品，再遍历背包容量
    for (int i = 1; i <= wlen; i++) {
      for (int j = 1; j <= bagsize; j++) {
        if (j < weight[i - 1]) {
          dp[i][j] = dp[i - 1][j];
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i - 1]] + value[i - 1]);
        }
      }
    }
    //打印dp数组
    for (int i = 0; i <= wlen; i++) {
      for (int j = 0; j <= bagsize; j++) {
        System.out.print(dp[i][j] + " ");
      }
      System.out.print("\n");
    }
  }


  public int f(int n, int restWeight, int[] w, int[] v) {
    if (n == 0 || restWeight == 0) { //当物品数量为0，或者背包容量为0时，最优解为0
      return 0;
    } else {//如果当前要判断的物品重量大于背包当前所剩的容量，那么就不选择这个物品
      //在这种情况的最优解为f(n-1,C)
      if (w[n - 1] > restWeight) {
        return f(n - 1, restWeight, w, v);
      } else {
        //如果当前待判断的物品重量wi
        int tmp1 = f(n - 1, restWeight, w, v);//不选择物品i的情况下的最优解
        int tmp2 = f(n - 1, restWeight - w[n - 1], w, v) + v[n - 1];//选择物品i的情况下的最优解
        //返回选择物品i和不选择物品i中最优解大的一个
        return tmp1 > tmp2 ? tmp1 : tmp2;
      }
    }
  }
}
