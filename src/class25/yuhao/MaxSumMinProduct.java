package class25.yuhao;

import java.util.Arrays;
import java.util.Stack;

/**
 * 给定一个只包含正数的数组 arr, arr 中任何一个子数组 sub,
 * 一定都可以算出(sub累加和)*(sub中的最小值)是什么，
 * 那么所有子数组中，这个值最大是多少？
 * 1856:https://leetcode.com/problems/maximum-subarray-min-product
 */
public class MaxSumMinProduct {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 2, 3, 4, 5};
        MaxSumMinProduct product = new MaxSumMinProduct();
        Arrays.stream(product.preSum(arr)).forEach(it -> System.out.print(it + " "));
    }

    public int maxSumMinProduct(int[] arr) {
        long max = 0;
        int N = arr.length;
        long[] sums = preSum(arr);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                long sum = 0;
                int index = stack.pop();
                int value = arr[index];
                if (stack.isEmpty()) {
                    sum = sums[i - 1];
                } else {
                    sum = sums[i - 1] - sums[stack.peek()];
                }
                long res = sum * value;
                max = Math.max(max, res);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            long sum = 0;
            int index = stack.pop();
            int value = arr[index];
            if (stack.isEmpty()) {
                sum = sums[N - 1];
            } else {
                sum = sums[N - 1] - sums[stack.peek()];
            }
            long res = sum * value;
            max = Math.max(max, res);
        }
        return (int) (max % 1000000007);
    }

    private long[] preSum(int[] arr) {
        long[] ans = new long[arr.length];
        ans[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            ans[i] = ans[i - 1] + arr[i];
        }
        return ans;
    }
}
