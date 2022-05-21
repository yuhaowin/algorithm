package class01.yuhao;

/**
 * 插入排序，想象一下是在打扑克
 * 0 - 0 范围有序
 * 0 - 1 范围有序
 * 0 - 2 范围有序
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 4, 2, 1, 5, 6};
        InsertionSort sort = new InsertionSort();
        sort.sort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    /**
     * 插入排序
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
                //从后往前看，找到一个不满足，就可以退出了
                //因为前面都是有序的了。
                //最好的时间是数据有序，为 O(N)
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                } else {
                    break;
                }
            }
        }
        return nums;
    }

    //------------------------------------------------------------------------------------------------------------------

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
