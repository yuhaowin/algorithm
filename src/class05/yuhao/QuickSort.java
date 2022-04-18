package class05.yuhao;

/**
 * 快速排序/分区交换排序 quickSort / partition exchange sort
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] nums = new int[]{4, 7, 3, 6, 1, 9, 8, 0, 3};
        QuickSort quickSort = new QuickSort();
        quickSort.quickSortVersion1(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public void quickSortVersion1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        processVersion1(arr, 0, arr.length - 1);
    }

    private void processVersion1(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        // L..R partition arr[R] [ <=arr[R] arr[R] >arr[R] ]
        int M = partition(arr, L, R);
        processVersion1(arr, L, M - 1);
        processVersion1(arr, M + 1, R);
    }

    private int partition(int[] arr, int L, int R) {
        if (L > R) {
            return -1;
        }
        if (L == R) {
            return L;
        }
        int lessEqual = L - 1;
        int index = L;
        while (index < R) {
            if (arr[index] <= arr[R]) {
                swap(arr, index, ++lessEqual);
            }
            index++;
        }
        swap(arr, ++lessEqual, R);
        return lessEqual;
    }

    //------------------------------------------------------------------------------------------------------------------

    public void quickSortVersion2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        processVersion2(arr, 0, arr.length - 1);
    }

    private void processVersion2(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        int[] result = netherlandsFlag(arr, L, R);
        processVersion2(arr, L, result[0] - 1);
        processVersion2(arr, result[1] + 1, R);
    }

    //------------------------------------------------------------------------------------------------------------------

    public void quickSortVersion3(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        processVersion2(arr, 0, arr.length - 1);
    }

    public void processVersion3(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        swap(arr, L + (int) (Math.random() * (R - L + 1)), R);
        int[] equalArea = netherlandsFlag(arr, L, R);
        processVersion3(arr, L, equalArea[0] - 1);
        processVersion3(arr, equalArea[1] + 1, R);
    }

    /**
     * 返回等于区域的下标
     */
    private int[] netherlandsFlag(int[] arr, int L, int R) {
        if (L > R) {
            return new int[]{-1, -1};
        }
        if (L == R) {
            return new int[]{L, R};
        }
        int less = L - 1;   // < 区 右边界
        int more = R;       // > 区 左边界
        int index = L;
        while (index < more) { // 当前位置，不能和 >区的左边界撞上
            if (arr[index] == arr[R]) {
                index++;
            } else if (arr[index] < arr[R]) {
                swap(arr, less + 1, index);
                less++;
                index++;
            } else if (arr[index] > arr[R]) {
                swap(arr, index, more - 1);
                more--;
            }
        }
        swap(arr, more, R); // <[R]   =[R]   >[R]
        return new int[]{less + 1, more};
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
