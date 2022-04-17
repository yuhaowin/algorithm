package class04.yuhao;

import java.util.HashMap;
import java.util.Map;

/**
 * 统计之前数小于当前数的个数
 * todo
 */
public class CountOfSmallerNumbersBeforeSelf {

    static int ans = 0;

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
    public static void process(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        // l < r
        int mid = l + ((r - l) >> 1);
        process(arr, l, mid);
        process(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    public static void merge(int[] arr, int L, int m, int r) {
        int[] help = new int[r - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = m + 1;
        while (p1 <= m && p2 <= r) {
            ans += arr[p1] < arr[p2] ? (r - p2 + 1) * arr[p1] : 0;
            if (arr[p1] < arr[p2]) {
                map.put(p1, map.get(p1) + (r - p2 + 1));
            }
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= m) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
    }


    public static void main(String[] args) {
        int[] test = new int[]{6, 4, 5};
        smallSum(test);
        System.out.println(ans);
        for (int i : test) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
