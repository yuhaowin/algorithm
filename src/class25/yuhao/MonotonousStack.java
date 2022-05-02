package class25.yuhao;

import java.util.Arrays;
import java.util.Stack;

/**
 * 单调栈是什么?
 * 一种特别设计的栈结构,为了解决如下的问题:
 * 给定一个可能含有重复值的数组 arr, i 位置的数一定存在如下两个信息
 * 1、arr 的左侧离 i 最近并且小于(或者大于) arr[i] 的数在哪?
 * 2、arr 的右侧离 i 最近并且小于(或者大于) arr[i] 的数在哪?
 * 如果想得到 arr 中所有位置的两个信息，怎么能让得到信息的过程尽量快。
 * 那么到底怎么设计呢
 */
public class MonotonousStack {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        MonotonousStack stack = new MonotonousStack();
        Arrays.stream(stack.monotonousStack(arr)).forEach(it -> {
            Arrays.stream(it).forEach(x -> System.out.print(x + " "));
            System.out.println();
        });
    }

    public int[][] monotonousStack(int[] arr) {
        int N = arr.length;
        int[][] ans = new int[N][2];

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                int j = stack.pop();
                int x = stack.isEmpty() ? -1 : stack.peek();
                ans[j][0] = x;
                ans[j][1] = i;
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int j = stack.pop();
            int x = stack.isEmpty() ? -1 : stack.peek();
            ans[j][0] = x;
            ans[j][1] = -1;
        }
        return ans;
    }
}
