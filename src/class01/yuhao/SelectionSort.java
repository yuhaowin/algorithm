package class01.yuhao;

/**
 * 选择排序
 */
public class SelectionSort {

    /**
     * 选择排序 O(n^2)
     * 0 - N-1    选择 min value 放在 0 位置
     * 1 - N-1    选择 min value 放在 1 位置
     * 2 - N-1    选择 min value 放在 2 位置
     * 3 - N-1    选择 min value 放在 3 位置
     * N-2 - N-1  选择 min value 放在 N-2 位置
     */
    public int[] sort(int[] nums) {
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
