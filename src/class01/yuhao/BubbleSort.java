package class01.yuhao;

/**
 * 冒泡排序
 */
public class BubbleSort {

    /**
     * 冒泡排序 O(n^2)
     * 0 - N-1 范围，当前数和后一个数比较，谁大谁往后  -> N-1 位置数最大
     * 0 - N-2 范围，当前数和后一个数比较，谁大谁往后  -> N-2 位置数第二大
     * 0 - N-3 范围，当前数和后一个数比较，谁大谁往后  -> N-2 位置数第三大
     * 0 - N-4 范围，当前数和后一个数比较，谁大谁往后  -> N-2 位置数第四大
     */
    public int[] sort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        int N = nums.length;
        for (int i = N - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }
        }
        return nums;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
