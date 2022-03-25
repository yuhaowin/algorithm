package class21.yuhao_dp;

import java.util.HashMap;
import java.util.Map;

/**
 * arr 是货币数组，其中的值都是正数。再给定一个正数 aim。
 * <p>
 * 每个值都认为是一张货币，认为值相同的货币没有任何不同，
 * <p>
 * 返回组成 aim 的方法数
 * <p>
 * 例如：arr={1,2,1,1,2,1,2}、aim = 4
 * <p>
 * 方法：1+1+1+1、1+1+2、2+2
 * <p>
 * 一共就3种方法，所以返回 3
 */
public class CoinsWaySameValueSamePaper {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 1, 1, 2, 1, 2};
        int aim = 4;

        Info info = getInfo(arr);
        int[] coins = info.coins;
        int[] zhang = info.zhangs;

        CoinsWaySameValueSamePaper samePaper = new CoinsWaySameValueSamePaper();
        System.out.println(samePaper.process(coins, zhang, aim));
        System.out.println(samePaper.dp1(coins, zhang, aim));
        System.out.println(samePaper.dp2(coins, zhang, aim));
    }


    public int process(int[] coins, int[] zhang, int aim) {
        return recursive(coins, zhang, 0, aim);
    }

    public int recursive(int[] coins, int[] zhangs, int index, int rest) {
        if (index == coins.length) {
            return rest == 0 ? 1 : 0;
        }

        int current = coins[index];
        int count = zhangs[index];

        int ways = 0;
        for (int zhang = 0; zhang * current <= rest && zhang <= count; zhang++) {
            ways += recursive(coins, zhangs, index + 1, rest - (zhang * current));
        }

        return ways;
    }

    //------------------------------------------------------------------------------------------------------------------


    public int dp1(int[] coins, int[] zhangs, int aim) {
        int N = coins.length;

        int[][] dp = new int[N + 1][aim + 1];

        dp[N][0] = 1;

        for (int index = N - 1; index >= 0; index--) {
            int current = coins[index];
            int count = zhangs[index];

            for (int rest = 0; rest <= aim; rest++) {
                int ways = 0;
                for (int zhang = 0; zhang * current <= rest && zhang <= count; zhang++) {
                    ways += dp[index + 1][rest - (zhang * current)];
                }
                dp[index][rest] = ways;
            }
        }
        return dp[0][aim];
    }

    //------------------------------------------------------------------------------------------------------------------

    public int dp2(int[] coins, int[] zhangs, int aim) {
        int N = coins.length;

        int[][] dp = new int[N + 1][aim + 1];

        dp[N][0] = 1;

        for (int index = N - 1; index >= 0; index--) {
            int current = coins[index];
            int count = zhangs[index];

            for (int rest = 0; rest <= aim; rest++) {

                dp[index][rest] = dp[index + 1][rest];

                if (rest >= current) {
                    dp[index][rest] += dp[index][rest - current];
                }

                // 由于钱的张数是有限的，需要减去重复加的。
                if (rest >= (count + 1) * current) {
                    dp[index][rest] -= dp[index + 1][rest - (count + 1) * current];
                }
            }
        }
        return dp[0][aim];
    }

    //------------------------------------------------------------------------------------------------------------------

    public static Info getInfo(int[] arr) {
        HashMap<Integer, Integer> counts = new HashMap<>();
        for (int value : arr) {
            if (!counts.containsKey(value)) {
                counts.put(value, 1);
            } else {
                counts.put(value, counts.get(value) + 1);
            }
        }
        int N = counts.size();
        int[] coins = new int[N];
        int[] zhangs = new int[N];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            coins[index] = entry.getKey();
            zhangs[index++] = entry.getValue();
        }
        return new Info(coins, zhangs);
    }

    public static class Info {
        public int[] coins;
        public int[] zhangs;

        public Info(int[] c, int[] z) {
            coins = c;
            zhangs = z;
        }
    }
}
