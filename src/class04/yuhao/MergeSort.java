package class04.yuhao;

/**
 * 归并排序 N*logN,空间复杂的 N，需要一个辅助数组
 * recursive(arr,L,R) 有序
 * 1、求 M
 * 2、L-M 有序
 * 3、M+1-R 有序
 * 4、合并整体有序 - 两个指针指向两部分，比较后拷贝。merge 过程 O(N)
 * 归并快的原因是，上一次的排序结果加快了下一次排序的过程
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 4, 2, 1, 5, 6};
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort2(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    /**
     * 递归实现
     */
    public void mergeSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        recursive(arr, 0, arr.length - 1);
    }

    // arr L,R 范围有序
    private void recursive(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int M = (L + R) / 2;
        recursive(arr, L, M);
        recursive(arr, M + 1, R);
        merge(arr, L, M, R);
    }

    //------------------------------------------------------------------------------------------------------------------

    /**
     * 迭代实现
     * 每次调整步长，1，2，4，8 调整了 logN 次
     * 每次 merge 的过程是 O(N) -> 总体 N*logN
     */
    public void mergeSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int N = arr.length;
        // 起始步长
        int mergeSize = 1;
        while (mergeSize < N) { // loop logN 次
            // 当前左组的，第一个位置,下一次会跳到下一个左组的第一个位置。
            int L = 0;
            while (L < N) {//loop 每一对左右组，进行 merge
                if (mergeSize >= N - L) {//剩下的数不够左组,也就没有右组，不需要 merge
                    break;
                }
                int M = L + mergeSize - 1;
                // 如右组也够的话，来到 M + 步长的位置，最长不能超过 N-1
                int R = Math.min(mergeSize + M, N - 1);
                merge(arr, L, M, R);
                L = R + 1;
            }
            // 防止溢出
            if (mergeSize > N / 2) {
                break;
            }
            // 步长 * 2
            mergeSize <<= 1;
        }
    }

    private void merge(int[] arr, int L, int M, int R) {
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        int[] help = new int[R - L + 1];
        while (p1 <= M && p2 <= R) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        // 要么 p1 越界了，要么 p2 越界了
        while (p1 <= M) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        for (int j = 0; j < help.length; j++) {
            arr[L + j] = help[j];
        }
    }
}
