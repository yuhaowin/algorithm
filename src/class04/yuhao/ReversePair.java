package class04.yuhao;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组，求出这个数组中的逆序对的总数。
 * https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/
 */
public class ReversePair {
    /**
     * 输入: [7,5,6,4]
     * 输出: 5
     */
    public static void main(String[] args) {
        int[] nums = new int[]{7, 5, 6, 4};
        ReversePair reversePair = new ReversePair();
        System.out.println(reversePair.reversePairs(nums) == 5);
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public int reversePairs(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        return process(nums, 0, nums.length - 1);
    }

    private int process(int[] arr, int L, int R) {
        if (L == R) {
            return 0;
        }
        //int M = (L + R) / 2;
        int M = L + ((R - L) >> 1);
        int left = process(arr, L, M);
        int right = process(arr, M + 1, R);
        int merge = merge(arr, L, M, R);
        return left + right + merge;
    }

    private int merge(int[] arr, int L, int M, int R) {
        int i = 0;
        int res = 0;
        int p1 = L;
        int p2 = M + 1;
        int[] help = new int[R - L + 1];
        while (p1 <= M && p2 <= R) {
            if (arr[p1] > arr[p2]) {
                // 右侧 p2 - R 都是符合要求的。
                res += R - p2 + 1;
                help[i++] = arr[p1++];
            } else {
                help[i++] = arr[p2++];
            }
        }
        while (p1 <= M) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        for (int j = 0; j < help.length; j++) {
            arr[L + j] = help[j];
        }
        return res;
    }

    /**
     * 另外一种方法
     */
    private int merge1(int[] arr, int L, int M, int R) {
        int i = R - L;
        int res = 0;
        int p1 = M;
        int p2 = R;
        int[] help = new int[R - L + 1];
        while (p1 >= L && p2 > M) {
            res += arr[p1] > arr[p2] ? (p2 - M) : 0;
            help[i--] = arr[p1] > arr[p2] ? arr[p1--] : arr[p2--];
        }
        while (p1 >= L) {
            help[i--] = arr[p1--];
        }
        while (p2 > M) {
            help[i--] = arr[p2--];
        }
        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
        return res;
    }
}
