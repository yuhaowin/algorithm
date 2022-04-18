package class24.yuhao;

import java.util.LinkedList;

/**
 * 给定一个整型数组 arr，和一个整数 num
 * 某个 arr 中的子数组 sub，如果想达标，必须满足：
 * sub 中最大值 - sub 中最小值 <= num，
 * 返回 arr 中达标子数组的数量
 */
public class AllLessNumSubArray {

    public static void main(String[] args) {
        int[] test = new int[]{4, 3, 5, 4, 3, 3, 6, 7};
        int num = 1;
        AllLessNumSubArray allLessNumSubArray = new AllLessNumSubArray();
        int x = 10;
        int count = 0;
        for (int i = 0; i < x; i++) {
            for (int j = i; j < x; j++) {
                count++;
            }
        }
        System.out.println(count);
        System.out.println(allLessNumSubArray.tetet(test, num));
    }

    public int test(int[] arr, int num) {
        int N = arr.length;
        LinkedList<Integer> queue = new LinkedList<>();
        int res = 0;
        queue.addLast(arr[0]);
        for (int R = 1; R < N; R++) {
            while (!queue.isEmpty() && queue.peekLast() <= arr[R]) {
                queue.pollLast();
            }
            queue.addLast(arr[R]);
            if (queue.peekFirst() - queue.peekLast() <= num) {
                res++;
            }
            for (int L = 0; L < R; L++) {
                queue.peekFirst();
                if (queue.peekFirst() - queue.peekLast() <= num) {
                    res++;
                }
            }
        }
        return res;
    }


    public int tetet(int[] arr, int num) {
        int N = arr.length;
        LinkedList<Integer> min = new LinkedList<>();
        LinkedList<Integer> max = new LinkedList<>();
        int res = 0;
        int R = 0;
        for (int L = 0; L < N; L++) {
            while (R < N) {
                while (!min.isEmpty() && arr[min.peekLast()] >= arr[R]) {
                    min.pollLast();
                }
                min.addLast(R);
                while (!max.isEmpty() && arr[max.peekLast()] <= arr[R]) {
                    max.pollLast();
                }
                max.addLast(R);

                if (arr[max.peekFirst()] - arr[min.peekFirst()] > num) {
                    break;
                } else {
                    R++;
                }
            }
            res += R - L;
            if (min.peekFirst() == L) {
                min.pollFirst();
            }
            if (max.peekFirst() == L) {
                max.pollFirst();
            }
        }
        return res;
    }
}
