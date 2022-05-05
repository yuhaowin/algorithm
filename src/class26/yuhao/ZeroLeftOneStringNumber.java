package class26.yuhao;

/**
 * 给定一个数N，想象只由0和1两种字符，组成的所有长度为N的字符串
 * 如果某个字符串，任何0字符的左边都有1紧挨着，认为这个字符串达标
 * 返回有多少达标的字符串
 */
public class ZeroLeftOneStringNumber {

    public static void main(String[] args) {

    }

    public static int getNum1(int n) {
        if (n < 1) {
            return 0;
        }
        return xx(n);
    }

    public static int xx(int n) {
        if (n < 4) {
            return n;
        }
        return xx(n - 1) + xx(n - 2);
    }

}
