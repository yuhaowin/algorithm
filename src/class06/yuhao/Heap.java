package class06.yuhao;

import java.util.PriorityQueue;

public class Heap {

    public static void main(String[] args) {
        int value = 1000;
        int limit = 100;
        int testTimes = 1000000;
        for (int i = 0; i < testTimes; i++) {
            int curLimit = (int) (Math.random() * limit) + 1;
            Heap my = new Heap(curLimit);
            // 大的优先，大根堆
            PriorityQueue<Integer> test = new PriorityQueue<>(((o1, o2) -> o2 - o1));
            int curOpTimes = (int) (Math.random() * limit);
            for (int j = 0; j < curOpTimes; j++) {
                if (my.isEmpty() != test.isEmpty()) {
                    System.out.println("Oops!");
                }
                if (my.isFull()) {
                    if (my.pop() != test.poll()) {
                        System.out.println("Oops!");
                    }
                } else {
                    if (Math.random() < 0.5) {
                        int curValue = (int) (Math.random() * value);
                        my.push(curValue);
                        test.add(curValue);
                    } else {
                        if (my.isEmpty()) {
                            continue;
                        }
                        if (my.pop() != test.poll()) {
                            System.out.println("Oops!");
                        }
                    }
                }
            }
        }
        System.out.println("finish!");
    }


    private int[] heap;
    private int heapSize;
    private final int limit;

    public Heap(int limit) {
        heapSize = 0;
        this.limit = limit;
        this.heap = new int[limit];
    }

    public boolean isEmpty() {
        return heapSize == 0;
    }

    public boolean isFull() {
        return heapSize == limit;
    }

    public void push(int value) {
        if (isFull()) {
            throw new RuntimeException("heap is full");
        }
        heap[heapSize] = value;
        shiftUp(heap, heapSize);
        heapSize++;
    }

    // 用户此时，让你返回最大值，并且在大根堆中，把最大值删掉
    // 剩下的数，依然保持大根堆组织
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("heap is empty");
        }
        int ans = heap[0];
        heapSize--;
        swap(heap, 0, heapSize);
        shiftDown(heap, 0, heapSize);
        return ans;
    }

    // 新加进来的数，现在停在了index位置，请依次往上移动，
    // 移动到0位置，或者干不掉自己的父亲了，停！
    private void shiftUp(int[] heap, int index) {
        // (index - 1) / 2 是当前节点的父节点
        while (heap[index] > heap[(index - 1) / 2]) {
            swap(heap, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    // 从index位置，往下看，不断的下沉
    // 停：较大的孩子都不再比index位置的数大；已经没孩子了
    private void shiftDown(int[] heap, int index, int heapSize) {
        int leftIndex = 2 * index + 1;
        int rightIndex = 2 * index + 2;
        while (leftIndex < heapSize) {
            // 获取较大的子节点
            int largestIndex = rightIndex < heapSize && heap[leftIndex] < heap[rightIndex] ? rightIndex : leftIndex;
            // 获取最大的节点
            largestIndex = heap[largestIndex] > heap[index] ? largestIndex : index;

            if (largestIndex == index) {
                break;
            }

            swap(heap, largestIndex, index);
            index = largestIndex;
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
