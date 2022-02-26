package class17.yuhao_recursive;

/**
 * 汉诺塔
 */
public class Hanoi {

  public static void main(String[] args) {
    Hanoi hanoi = new Hanoi();
    hanoi.moveleft2right(3);
    System.out.println("----------------------------");
    hanoi.func(3, "left", "right", "mid");
  }

  public void moveleft2right(int n) {
    if (n == 1) {//最后一步，可以直接移动
      System.out.println(String.format("move %s from left to right", n));
      return;
    }
    moveleft2mid(n - 1);
    System.out.println(String.format("move %s from left to right", n));
    movemid2right(n - 1);
  }

  private void movemid2right(int i) {
    if (i == 1) {
      System.out.println(String.format("move %s from mid to right", i));
      return;
    }
    movemid2left(i - 1);
    System.out.println(String.format("move %s from mid to right", i));
    moveleft2right(i - 1);
  }

  private void movemid2left(int i) {
    if (i == 1) {
      System.out.println(String.format("move %s from mid to left", i));
      return;
    }
    movemid2right(i - 1);
    System.out.println(String.format("move %s from mid to left", i));
    moveright2left(i - 1);
  }

  private void moveright2left(int i) {
    if (i == 1) {
      System.out.println(String.format("move %s from right to left", i));
      return;
    }
    moveright2mid(i - 1);
    System.out.println(String.format("move %s from right to left", i));
    movemid2left(i - 1);
  }

  private void moveleft2mid(int i) {
    if (i == 1) {
      System.out.println(String.format("move %s from left to mid", i));
      return;
    }
    moveleft2right(i - 1);
    System.out.println(String.format("move %s from left to mid", i));

    moveright2mid(i - 1);
  }

  private void moveright2mid(int i) {
    if (i == 1) {
      System.out.println(String.format("move %s from right to mid", i));
      return;
    }
    moveright2left(i - 1);
    System.out.println(String.format("move %s from right to mid", i));
    moveleft2mid(i - 1);
  }

  //================================================================================================

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
