package class21.yuhao_dp;

/**
 * 最短路径和
 */
public class MinPathSum {

  public static void main(String[] args) {
    int[][] arr = {
        {1, 2, 2, 2},
        {1, 1, 2, 2},
        {2, 1, 1, 2},
        {2, 2, 1, 1},
    };
    MinPathSum minPathSum = new MinPathSum();
    System.out.println(minPathSum.process(arr));
  }

  public int process(int[][] arr) {
    return test(arr, 0, 0);
  }

  public int test(int[][] arr, int x, int y) {
    int row = arr.length - 1;
    int column = arr[0].length - 1;
    if (x == row && y == column) {
      return arr[x][y];
    }
    if (x == row) {
      return arr[x][y] + test(arr, x, y + 1);
    }
    if (y == column) {
      return arr[x][y] + test(arr, x + 1, y);
    }
    int p1 = test(arr, x, y + 1);
    int p2 = test(arr, x + 1, y);

    return Math.min(p1, p2) + arr[x][y];
  }
}
