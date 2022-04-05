package class11.yuhao;

/**
 * 请把一段纸条竖着放在桌子上，然后从纸条的下边向上方对折1次，压出折痕
 * 后展开。比时折痕是口下去的，即折痕突起的方向指向纸条的背面。如果从
 * 纸条的下边向上方连续对折2次，压出折痕后展开，此时有三条折痕，从上到
 * 下依次是下折痕、下折痕和上折痕。
 * 给定一企输入参数N，代表纸条都从下边向上方连续对折N次。请从上到下打
 * 印所有折痕的方向。
 * <p>
 * 例如：N=1时，打印：down N=2时，打印： down down up
 */
public class Paper {
    public static void main(String[] args) {
        Paper paper = new Paper();
        paper.print(1, 3, true);
    }

    public void print(int i, int N, boolean down) {
        if (i > N) {
            return;
        }
        print(i + 1, N, true);
        System.out.print(down ? "凹" : "凸");
        print(i + 1, N, false);
    }
}
