package class17.yuhao_recursive;

/**
 * 汉诺塔
 */
public class Hanoi {

    public static void main(String[] args) {
        Hanoi hanoi = new Hanoi();
        hanoi.moveLeft2Right(3);
        System.out.println("------------------------------------");
        hanoi.func(3, "left", "right", "mid");
    }

    private void moveLeft2Right(int n) {
        if (n == 1) {//最后一步，可以直接移动
            System.out.println(String.format("move %s from left to right", n));
            return;
        }
        moveLeft2Mid(n - 1);
        System.out.println(String.format("move %s from left to right", n));
        moveMid2Right(n - 1);
    }

    private void moveMid2Right(int i) {
        if (i == 1) {
            System.out.println(String.format("move %s from mid to right", i));
            return;
        }
        moveMid2Left(i - 1);
        System.out.println(String.format("move %s from mid to right", i));
        moveLeft2Right(i - 1);
    }

    private void moveMid2Left(int i) {
        if (i == 1) {
            System.out.println(String.format("move %s from mid to left", i));
            return;
        }
        moveMid2Right(i - 1);
        System.out.println(String.format("move %s from mid to left", i));
        moveRight2Left(i - 1);
    }

    private void moveRight2Left(int i) {
        if (i == 1) {
            System.out.println(String.format("move %s from right to left", i));
            return;
        }
        moveRight2Mid(i - 1);
        System.out.println(String.format("move %s from right to left", i));
        moveMid2Left(i - 1);
    }

    private void moveLeft2Mid(int i) {
        if (i == 1) {
            System.out.println(String.format("move %s from left to mid", i));
            return;
        }
        moveLeft2Right(i - 1);
        System.out.println(String.format("move %s from left to mid", i));

        moveRight2Mid(i - 1);
    }

    private void moveRight2Mid(int i) {
        if (i == 1) {
            System.out.println(String.format("move %s from right to mid", i));
            return;
        }
        moveRight2Left(i - 1);
        System.out.println(String.format("move %s from right to mid", i));
        moveLeft2Mid(i - 1);
    }

    //------------------------------------------------------------------------------------------------------------------

    private void func(int n, String from, String to, String other) {
        if (n == 1) {
            System.out.println(String.format("move %s from %s to %s", n, from, to));
            return;
        }
        func(n - 1, from, other, to);
        System.out.println(String.format("move %s from %s to %s", n, from, to));
        func(n - 1, other, to, other);
    }
}
