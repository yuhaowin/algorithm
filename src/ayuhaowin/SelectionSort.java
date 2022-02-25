package ayuhaowin;

/**
 * @author yuhao
 * @version 5.11.0
 * @date 2021年07月26日 23:53:00
 */
public class SelectionSort {

    /**
     * https://leetcode.com/problems/sort-an-array/
     * time limit exceeded
     *
     * @param nums
     * @return
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

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
