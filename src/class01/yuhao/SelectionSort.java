package class01.yuhao;

/**
 * 选择排序
 */
public class SelectionSort {

    /**
     * https://leetcode.com/problems/sort-an-array/
     * time limit exceeded
     */
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        int N = nums.length;
        for (int i = 0; i < N; i++) {
            int minimumIndex = i;
            for (int j = i + 1; j < N; j++) {
                if (nums[minimumIndex] > nums[j]) {
                    minimumIndex = j;
                }
            }
            swap(nums, minimumIndex, i);
        }
        return nums;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
