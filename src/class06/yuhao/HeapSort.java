package class06.yuhao;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {

        int[] arr = new int[]{3, 2, 6, 1, 9, 5, 0, 4, 7};

        System.out.print("before: ");
        Arrays.stream(arr).forEach(it -> System.out.print(it + " "));
        HeapSort heapSort = new HeapSort();
        heapSort.sort(arr);
        System.out.println();
        System.out.print("after : ");
        Arrays.stream(arr).forEach(it -> System.out.print(it + " "));
    }


    public void sort(int[] arr) {

        for (int index = 0; index < arr.length; index++) {
            heapInsert(arr, index);
        }

        int heapSize = arr.length;
        while (heapSize > 0) {
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }
    }

    // 新的数据已经在 index 位置，要调整成一个 heap
    private void heapInsert(int[] heap, int index) {
        int parentIndex = (index - 1) / 2;
        while (heap[index] > heap[parentIndex]) {
            swap(heap, index, parentIndex);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    private void heapify(int[] heap, int index, int heapSize) {

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
