package class18.yuhao_dp;

/**
 * 给定一个整型数组 arr，代表数值不同的纸牌排成一条线
 * <p>
 * 玩家 A 和玩家 B 依次拿走每张纸牌
 * 规定玩家 A 先拿，玩家 B 后拿
 * 但是每个玩家每次只能拿走最左或最右的纸牌
 * 玩家 A 和玩家 B 都绝顶聪明
 * 请返回最后获胜者的分数。
 */
public class CardsInLine {

    public static void main(String[] args) {
        int[] cards = new int[]{1, 100, 10};
        cards = new int[]{5, 7, 4, 5, 8, 1, 6, 0, 3, 4, 6, 1, 7};
        CardsInLine cardsInLine = new CardsInLine();

        System.out.println(cardsInLine.process1(cards));
        System.out.println(cardsInLine.process2(cards));
    }

    //------------------------------------------------------------------------------------------------------------------

    private int process1(int[] arr) {
        int a = f1(arr, 0, arr.length - 1);
        int b = g1(arr, 0, arr.length - 1);
        return Math.max(a, b);
    }

    /**
     * 先手，在 L - R 范围内拿到最好的分数
     */
    private int f1(int[] arr, int L, int R) {
        if (L == R) {
            return arr[L];
        }
        int p1 = arr[L] + g1(arr, L + 1, R);
        int p2 = arr[R] + g1(arr, L, R - 1);
        return Math.max(p1, p2);
    }

    /**
     * 后手，在 L - R 范围内拿到最差的分数
     */
    private int g1(int[] arr, int L, int R) {
        if (L == R) {
            return 0;
        }
        int p1 = f1(arr, L + 1, R);
        int p2 = f1(arr, L, R - 1);
        return Math.min(p1, p2);
    }

    //------------------------------------------------------------------------------------------------------------------

    private int process2(int[] arr) {
        int N = arr.length;
        int[][] fmap = new int[N][N];
        int[][] gmap = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                fmap[i][j] = gmap[i][j] = -1;
            }
        }
        int a = f2(arr, 0, arr.length - 1, fmap, gmap);
        int b = g2(arr, 0, arr.length - 1, fmap, gmap);
        return Math.max(a, b);
    }

    private int f2(int[] arr, int L, int R, int[][] fmap, int[][] gmap) {
        if (L == R) {
            return arr[L];
        }
        if (fmap[L][R] != -1) {
            return fmap[L][R];
        }
        int p1 = arr[L] + g2(arr, L + 1, R, fmap, gmap);
        int p2 = arr[R] + g2(arr, L, R - 1, fmap, gmap);
        int result = Math.max(p1, p2);
        fmap[L][R] = result;
        return result;
    }

    private int g2(int[] arr, int L, int R, int[][] fmap, int[][] gmap) {
        if (L == R) {
            return 0;
        }
        if (gmap[L][R] != -1) {
            return gmap[L][R];
        }
        int p1 = f2(arr, L + 1, R, fmap, gmap);
        int p2 = f2(arr, L, R - 1, fmap, gmap);
        int result = Math.min(p1, p2);
        gmap[L][R] = result;
        return result;
    }
}
