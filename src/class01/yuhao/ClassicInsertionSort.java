package class01.yuhao;

/**
 * 插入排序
 */
public class ClassicInsertionSort {

    /**
     * 插入排序 classic 插入排序
     * 时间复杂度和数据有关，O(N) - O(n^2)
     * 0 - 0 有序
     * 0 - 1 有序
     * 0 - 2 有序
     * 0 - 3 有序
     * 0 - N-1 有序
     */
    public int[] sort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        int N = nums.length;
        for (int i = 0; i < N; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                } else {
                    break;
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
