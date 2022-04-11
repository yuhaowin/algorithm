package class18.yuhao_dp;

import java.util.HashMap;

/**
 * 斐波那契数
 * 1 1 2 3 5 8 13...
 */
public class Fibonacci {

    public static void main(String[] args) {
        int n = 7;
        Fibonacci fibonacci = new Fibonacci();
        System.out.println(fibonacci.process1(n));
        System.out.println(fibonacci.process2(n, new HashMap<>()));
    }

    //------------------------------------------------------------------------------------------------------------------

    private int process1(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return process1(n - 1) + process1(n - 2);
    }

    //------------------------------------------------------------------------------------------------------------------

    private int process2(int n, HashMap<Integer, Integer> cache) {
        if (n == 1 || n == 2) {
            return 1;
        }
        Integer left = cache.get(n - 1);
        if (left == null) {
            left = process2(n - 1, cache);
            cache.put(n - 1, left);
        }
        Integer right = cache.get(n - 2);
        if (right == null) {
            right = process2(n - 2, cache);
            cache.put(n - 2, left);
        }
        return left + right;
    }
}
