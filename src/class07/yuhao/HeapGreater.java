package class07.yuhao;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class HeapGreater<T> {

    private ArrayList<T> heap;
    private HashMap<T, Integer> indexMap;
    private int heapSize;
    private Comparator<? super T> comp;

    public HeapGreater(Comparator<T> c) {
        heap = new ArrayList<>();
        indexMap = new HashMap<>();
        heapSize = 0;
        comp = c;
    }

    public boolean isEmpty() {
        return heapSize == 0;
    }

    public int size() {
        return heapSize;
    }

    public boolean contains(T item) {
        return indexMap.containsKey(item);
    }

    public T peek() {
        return heap.get(0);
    }

    public void push(T item) {
        heap.add(item);
        indexMap.put(item, heapSize);
        shiftUp(heapSize);
        heapSize++;
    }

    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("is empty");
        }
        T result = heap.get(0);
        heapSize--;
        swap(0, heapSize);
        heap.remove(heapSize);
        indexMap.remove(result);
        shiftDown(0);
        return result;
    }

    public void remove(T obj) {
        heapSize--;
        int index = indexMap.get(obj);
        indexMap.remove(obj);
        T replace = heap.get(heapSize);
        heap.remove(heapSize);
        if (obj != replace) {
            heap.set(index, replace);
            indexMap.put(replace, index);
            resign(replace);
        }
    }

    public void resign(T item) {
        shiftUp(indexMap.get(item));
        shiftDown(indexMap.get(item));
    }

    // 请返回堆上的所有元素
    public List<T> getAllElements() {
        List<T> ans = new ArrayList<>();
        for (T c : heap) {
            ans.add(c);
        }
        return ans;
    }

    private void shiftUp(int index) {
        int parentIndex = (index - 1) / 2;

        while (comp.compare(heap.get(index), heap.get(parentIndex)) < 0) {
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    private void shiftDown(int index) {
        int leftIndex = 2 * index + 1;
        int rightIndex = 2 * index + 2;
        while (leftIndex < heapSize) {
            int bestIndex = rightIndex < heapSize && comp.compare(heap.get(rightIndex), heap.get(leftIndex)) < 0 ? rightIndex : leftIndex;
            bestIndex = comp.compare(heap.get(index), heap.get(bestIndex)) < 0 ? index : bestIndex;

            if (index == bestIndex) {
                break;
            }

            swap(index, bestIndex);

            index = bestIndex;
            leftIndex = 2 * index + 1;
            rightIndex = 2 * index + 2;
        }
    }

    private void swap(int i, int j) {
        T itemI = heap.get(i);
        T itemJ = heap.get(j);
        heap.set(i, itemJ);
        heap.set(j, itemI);
        indexMap.put(itemI, j);
        indexMap.put(itemJ, i);
    }
}
