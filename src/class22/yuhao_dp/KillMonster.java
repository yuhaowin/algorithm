package class22.yuhao_dp;

/**
 * 字节跳动 - 北美 - 原题
 * <p>
 * 给定 3 个参数，N， M，K
 * <p>
 * 怪兽有 N 滴血，等着英雄来砍自己
 * <p>
 * 英雄每一次打击，都会让怪兽流失 [0~M] 的血量
 * <p>
 * 到底流失多少？每一次在 [O-M] 上等概率的获得一个值
 * <p>
 * 求 K 次打击之后，英雄把怪兽砍死的概率
 */
public class KillMonster {

    public static void main(String[] args) {

        int N = 4;
        int M = 6;
        int K = 7;

        KillMonster t = new KillMonster();
        System.out.println(t.count(N, M, K));
    }

    public long count(int N, int M, int K) {
        return recursive(N, M, K);
    }

    public long recursive(int hp, int M, int rest) {

        if (rest == 0) {
            return hp <= 0 ? 1 : 0;
        }

        // 提升性能
        if (hp <= 0) {
            return (long) Math.pow(M + 1, rest);
        }

        int count = 0;
        for (int i = 0; i <= M; i++) {
            count += recursive(hp - i, M, rest - 1);
        }
        return count;
    }

    //--------------------------------------------------------------------------------------------------------------------


}
