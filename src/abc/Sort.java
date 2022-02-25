package abc;

/**
 * @author yuhao
 * @version 5.11.0
 * @date 2021年06月26日 22:42:00
 */
public class Sort {


    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    /**
     * 选择排序 O(n^2)
     * 0 - N-1 选择 min value 放在 0 位置
     * 1 - N-1 选择 min value 放在 1 位置
     * 2 - N-1 选择 min value 放在 2 位置
     * 3 - N-1 选择 min value 放在 3 位置
     * N-2 - N-1 选择 min value 放在 N-2 位置
     */
    public static void selectSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int N = arr.length;
        for (int i = 0; i < N; i++) {
            int minIndex = i;
            for (int j = i + 1; j < N; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    /**
     * 冒泡排序 O(n^2)
     * 0 - N-1 范围，当前数和后一个数比较，谁大谁往后  -> N-1 位置数最大
     * 0 - N-2 范围，当前数和后一个数比较，谁大谁往后  -> N-2 位置数第二大
     * 0 - N-3 范围，当前数和后一个数比较，谁大谁往后  -> N-2 位置数第三大
     * 0 - N-4 范围，当前数和后一个数比较，谁大谁往后  -> N-2 位置数第四大
     */
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int N = arr.length;
        for (int i = N - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    /**
     * 插入排序 classic 插入排序
     * 时间复杂度和数据有关，O(N) - O(n^2)
     * 0 - 0 有序
     * 0 - 1 有序
     * 0 - 2 有序
     * 0 - 3 有序
     * 0 - N-1 有序
     */
    public static void insertSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int N = arr.length;

//        for (int end = 1; end < N; end++) {
//            int currIndex = end;
//            while (currIndex - 1 >= 0 && arr[currIndex - 1] > arr[currIndex]) {
//                swap(arr, currIndex - 1, currIndex);
//                currIndex--;
//            }
//        }

        for (int end = 1; end < N; end++) {
            for (int currIndex = end; currIndex - 1 >= 0 && arr[currIndex - 1] > arr[currIndex]; currIndex--) {
                swap(arr, currIndex - 1, currIndex);
            }
        }
    }


    public static void main(String[] args) {

        int[] source = {3, 2, 5, 3, 7, 1, 8, 4, 9, 3, 8, 4, 0, 3, 8};

        print(source);
        //selectSort(source);
        //bubbleSort(source);
        insertSort(source);
        print(source);
    }

    /**
     * 时间复杂度的估算，分解到常数时间的小步骤
     * 某个算法的最优解：只需要保证时间复杂度低，空间复杂度低，即可，不用考虑常数时间优化
     */

}
