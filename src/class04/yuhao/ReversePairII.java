package class04.yuhao;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字的两倍，则这两个数字组成一个逆序对。
 * 输入一个数组，求出这个数组中的逆序对的总数。
 * https://leetcode-cn.com/problems/reverse-pairs/
 */
public class ReversePairII {

    /**
     * 输入: [1,3,2,3,1]
     * 输出: 2
     */
    public static void main(String[] args) {
        int[] nums = new int[]{2, 4, 3, 5, 1, 6};
        nums = new int[]{4, 1};
        ReversePairII reversePairII = new ReversePairII();
        System.out.println(reversePairII.reversePairs(nums));
        for (int num : nums) {
            System.out.print(num + " ");
        }
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
        int M = (L + R) / 2;
        int left = process(arr, L, M);
        int right = process(arr, M + 1, R);
        int merge = merge(arr, L, M, R);
        return left + right + merge;
    }

    private int merge(int[] arr, int L, int M, int R) {
        int res = 0;
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        int[] help = new int[R - L + 1];
        int temp = M + 1;
        for (int j = L; j <= M; j++) {
            while (temp <= R && (long) arr[j] > (long) arr[temp] * 2) {
                temp++;
            }
            res += temp - p2;
        }
        while (p1 <= M && p2 <= R) {
            if (arr[p1] < arr[p2]) {
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

    //错误的
    private int merge1(int[] arr, int L, int M, int R) {
        int res = 0;
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        int[] help = new int[R - L + 1];
        for (int j = L; j <= M; j++) {
            int temp = M + 1;
            while (temp <= R && (long) arr[j] > (long) arr[temp] * 2) {
                temp++;
            }
            res += R - temp;
        }
        while (p1 <= M && p2 <= R) {
            if (arr[p1] > arr[p2]) {
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
}
