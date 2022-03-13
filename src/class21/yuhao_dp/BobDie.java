package class21.yuhao_dp;

/**
 * 给定 5 个参数, N、M、row、col、k
 * <p>
 * 表示在 N*M 的区域上，醉汉 Bob 初始在 (row,col) 位置
 * <p>
 * Bob 一共要迈出 k 步，且每步都会等概率向上下左右四个方向走一个单位
 * <p>
 * 任何时候 Bob 只要离开 N*M 的区域，就直接死亡
 * <p>
 * 返回 k 步之后，Bob 还在 N*M 的区域的概率
 */
public class BobDie {

  public static void main(String[] args) {
    BobDie bobDie = new BobDie();
    int N = 50;
    int M = 50;
    int row = 6;
    int column = 6;
    int k = 10;
    int liveCount = bobDie.process(N, M, row, column, k);
    System.out.println(
        String.format("live count: %s , probability: %s", liveCount, liveCount / Math.pow(4, k)));
  }


  private int process(int N, int M, int row, int col, int k) {
    return test(N, M, row, col, k);
  }

  private int test(int N, int M, int currentRow, int currentCol, int rest) {
    if (currentRow < 0 || currentRow >= N) {
      return 0;
    }
    if (currentCol < 0 || currentCol >= M) {
      return 0;
    }

    if (rest == 0) {
      return 1;
    }

    int up = test(N, M, currentRow - 1, currentCol, rest - 1);
    int down = test(N, M, currentRow + 1, currentCol, rest - 1);
    int left = test(N, M, currentRow, currentCol - 1, rest - 1);
    int right = test(N, M, currentRow, currentCol + 1, rest - 1);

    //System.out.println(String.format("up:%s, down:%s, left:%s, right:%s", up, down, left, right));
    return up + down + left + right;
  }
}
