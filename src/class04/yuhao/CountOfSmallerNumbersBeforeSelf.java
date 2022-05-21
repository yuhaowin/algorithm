package class04.yuhao;

import java.util.HashMap;
import java.util.Map;

/**
 * 统计之后数大于当前数的个数
 */
public class CountOfSmallerNumbersBeforeSelf {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        smallSum(nums);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    static Map<Integer, Integer> map = new HashMap<>();

    public static void smallSum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            map.put(i, 0);
        }
        process(arr, 0, arr.length - 1);
    }

    // arr[L..R]既要排好序，也要求小和返回
    // 所有merge时，产生的小和，累加
    // 左 排序   merge
    // 右 排序  merge
    // merge
    public static void process(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int M = L + ((R - L) >> 1);
        process(arr, L, M);
        process(arr, M + 1, R);
        merge(arr, L, M, R);
    }

    public static void merge(int[] arr, int L, int M, int R) {
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        int[] help = new int[R - L + 1];
        while (p1 <= M && p2 <= R) {
            if (arr[p1] < arr[p2]) {
                map.put(p1, map.get(p1) + (R - p2 + 1));
            }
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= M) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
    }
}
