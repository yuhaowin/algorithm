package class06.yuhao;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {

        int[] arr = new int[]{3, 2, 6, 1, 9, 5, 0, 4, 7};

        System.out.print("before: ");
        Arrays.stream(arr).forEach(it -> System.out.print(it + " "));
        HeapSort heapSort = new HeapSort();
        heapSort.sort1(arr);
        heapSort.sort2(arr);
        System.out.println();
        System.out.print("after : ");
        Arrays.stream(arr).forEach(it -> System.out.print(it + " "));
    }


    public void sort1(int[] arr) {

        int heapSize = arr.length;

        // 从头一个一个插入形成 heap，时间复杂度为: O(N*logN)
        for (int index = 0; index < arr.length; index++) {
            shiftUp(arr, index);
        }

        while (heapSize > 0) {
            swap(arr, 0, --heapSize);
            shiftDown(arr, 0, heapSize);
        }
    }

    public void sort2(int[] arr) {

        int heapSize = arr.length;

        // 此过程叫 heapify 时间复杂的为: O(N)
        for (int index = arr.length / 2; index >= 0; index--) {
            shiftDown(arr, index, heapSize);
        }

        while (heapSize > 0) {
            swap(arr, 0, --heapSize);
            shiftDown(arr, 0, heapSize);
        }
    }

    // 新的数据已经在 index 位置，要调整成一个 heap
    private void shiftUp(int[] heap, int index) {
        int parentIndex = (index - 1) / 2;
        while (heap[index] > heap[parentIndex]) {
            swap(heap, index, parentIndex);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    private void shiftDown(int[] heap, int index, int heapSize) {
        int leftIndex = 2 * index + 1;
        int rightIndex = 2 * index + 2;

        while (leftIndex < heapSize) {
            int largeIndex = rightIndex < heapSize && heap[leftIndex] < heap[rightIndex] ? rightIndex : leftIndex;
            largeIndex = heap[largeIndex] > heap[index] ? largeIndex : index;

            if (largeIndex == index) {
                break;
            }

            swap(heap, largeIndex, index);

            index = largeIndex;
            leftIndex = 2 * index + 1;
            rightIndex = 2 * index + 2;
        }
    }

    private void swap(int[] heap, int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}
