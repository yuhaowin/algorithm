package class26.yuhao;

/**
 * 第一年农场有1只成熟的母牛A，往后的每年：
 * 1）每一只成熟的母牛都会生一只母牛
 * 2）每一只新出生的母牛都在出生的第三年成熟
 * 3）每一只母牛永远不会死
 * 返回 N 年后牛的数量
 */
public class Cow {

    public static void main(String[] args) {
        Cow cow = new Cow();
        for (int i = 1; i < 20; i++) {
            System.out.println(cow.recursive(i));
        }
    }


    private int recursive(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2 || n == 3) {
            return n;
        }
        // 去年所有的牛 + 3年前所有的牛生的小牛
        return recursive(n - 1) + recursive(n - 3);
    }
}
