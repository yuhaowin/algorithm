package class04.yuhao;

/**
 * 给定一个数组，在每一个位置上，所有小于当前位置的数，都累加起来，返回最后的结果
 */
public class SmallSum {

    public static void main(String[] args) {
        int[] test = new int[]{6, 4, 5};
        SmallSum smallSum = new SmallSum();
        System.out.println(smallSum.smallSum(test));
    }

    public int smallSum(int[] nums) {
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
        while (p1 <= M && p2 <= R) {
            if (arr[p1] < arr[p2]) {
                //如果 p1 < p2, 那么 p2 右边的都是大于 p1 的
                //所以p2 右边的每一个数都要选择加上 p1
                res += (R - p2 + 1) * arr[p1];
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
