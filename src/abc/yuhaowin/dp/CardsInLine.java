package abc.yuhaowin.dp;

/**
 * 给定一个整型数组arr，代表数值不同的纸牌排成一条线
 * <p>
 * 玩家A和玩家B依次拿走每张纸牌
 * <p>
 * 规定玩家A先拿，玩家B后拿
 * <p>
 * 但是每个玩家每次只能拿走最左或最右的纸牌
 * <p>
 * 玩家A和玩家B都绝顶聪明
 * <p>
 * 请返回最后获胜者的分数。
 */
public class CardsInLine {


  public static void main(String[] args) {
    int[] cards1 = {1, 100, 10};
    int[] cards = { 5, 7, 4, 5, 8, 1, 6, 0, 3, 4, 6, 1, 7 };
    CardsInLine cardsInLine = new CardsInLine();

    System.out.println(cardsInLine.process(cards));
    System.out.println(cardsInLine.process1(cards));
  }

  private int process(int[] arr) {
    int a = f(arr, 0, arr.length - 1);
    int b = g(arr, 0, arr.length - 1);
    return Math.max(a, b);
  }

  /**
   * 先手，在 L - R 范围内拿到最好的分数
   *
   * @param arr
   * @param L
   * @param R
   */
  private int f(int[] arr, int L, int R) {
    if (L == R) {
      return arr[L];
    }
    int p1 = arr[L] + g(arr, L + 1, R);
    int p2 = arr[R] + g(arr, L, R - 1);
    return Math.max(p1, p2);
  }

  private int g(int[] arr, int L, int R) {
    if (L == R) {
      return 0;
    }
    int p1 = f(arr, L + 1, R);
    int p2 = f(arr, L, R - 1);
    return Math.min(p1, p2);
  }

  //------------------------------------------------------------------------------------------------


  private int process1(int[] arr) {
    int N = arr.length;
    int[][] fmap = new int[N][N];
    int[][] gmap = new int[N][N];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        fmap[i][j] = gmap[i][j] = -1;
      }
    }
    int a = f1(arr, 0, arr.length - 1, fmap, gmap);
    int b = g1(arr, 0, arr.length - 1, fmap, gmap);
    return Math.max(a, b);
  }

  private int f1(int[] arr, int L, int R, int[][] fmap, int[][] gmap) {
    if (L == R) {
      return arr[L];
    }
    if (fmap[L][R] != -1) {
      return fmap[L][R];
    }

    int p1 = arr[L] + g1(arr, L + 1, R, fmap, gmap);
    int p2 = arr[R] + g1(arr, L, R - 1, fmap, gmap);
    int result = Math.max(p1, p2);
    fmap[L][R] = result;

    return result;
  }

  private int g1(int[] arr, int L, int R, int[][] fmap, int[][] gmap) {
    if (L == R) {
      return 0;
    }
    if (gmap[L][R] != -1) {
      return gmap[L][R];
    }

    int p1 = f1(arr, L + 1, R, fmap, gmap);
    int p2 = f1(arr, L, R - 1, fmap, gmap);
    int result = Math.min(p1, p2);
    gmap[L][R] = result;

    return result;
  }
}
