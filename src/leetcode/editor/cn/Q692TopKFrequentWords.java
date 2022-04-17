package leetcode.editor.cn;


import java.util.*;

public class Q692TopKFrequentWords {
    public static void main(String[] args) {
        Solution solution = new Q692TopKFrequentWords().new Solution();
        String[] words = new String[]{"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;
        List<String> result = solution.topKFrequent(words, k);
        result.stream().forEach(System.out::println);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> topKFrequent(String[] words, int k) {
            Map<String, Integer> cnt = new HashMap<>();
            for (String word : words) {
                cnt.put(word, cnt.getOrDefault(word, 0) + 1);
            }
            PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((entry1, entry2) -> entry1.getValue() == entry2.getValue() ? entry2.getKey().compareTo(entry1.getKey()) : entry1.getValue() - entry2.getValue());
            for (Map.Entry<String, Integer> entry : cnt.entrySet()) {
                pq.offer(entry);
                if (pq.size() > k) {
                    pq.poll();
                }
            }
            List<String> result = new ArrayList<>();
            while (!pq.isEmpty()) {
                result.add(pq.poll().getKey());
            }
            Collections.reverse(result);
            return result;
        }

        public List<String> topKFrequent1(String[] words, int k) {
            HashMap<String, Info> tempMap = new HashMap<>();
            HeapGreater<Info> heap = new HeapGreater<>((a, b) -> a.count == b.count ? a.word.compareTo(b.word) : b.count - a.count);

            for (String word : words) {
                if (tempMap.containsKey(word)) {
                    Info info = tempMap.get(word);
                    info.count++;
                    heap.resign(info);
                } else {
                    Info info = new Info(word, 1);
                    tempMap.put(word, info);
                    heap.push(info);
                }
            }

            List<String> result = new ArrayList<>(k);
            for (int i = 0; i < k; i++) {
                if (heap.isEmpty()) {
                    break;
                } else {
                    Info info = heap.pop();
                    result.add(info.word);
                }

            }
            return result;
        }
    }

    class Info {
        String word;
        int count;

        public Info(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }

    class HeapGreater<T> {

        private ArrayList<T> heap;
        private HashMap<T, Integer> indexMap;
        private int heapSize;
        private Comparator<? super T> comp;

        public HeapGreater(Comparator<? super T> c) {
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

        public boolean contains(T obj) {
            return indexMap.containsKey(obj);
        }

        public T peek() {
            return heap.get(0);
        }

        public void push(T obj) {
            heap.add(obj);
            indexMap.put(obj, heapSize);
            heapInsert(heapSize++);
        }

        public T pop() {
            T ans = heap.get(0);
            swap(0, heapSize - 1);
            indexMap.remove(ans);
            heap.remove(--heapSize);
            heapify(0);
            return ans;
        }

        public void remove(T obj) {
            T replace = heap.get(heapSize - 1);
            int index = indexMap.get(obj);
            indexMap.remove(obj);
            heap.remove(--heapSize);
            if (obj != replace) {
                heap.set(index, replace);
                indexMap.put(replace, index);
                resign(replace);
            }
        }

        public void resign(T obj) {
            heapInsert(indexMap.get(obj));
            heapify(indexMap.get(obj));
        }

        // 请返回堆上的所有元素
        public List<T> getAllElements() {
            List<T> ans = new ArrayList<>();
            for (T c : heap) {
                ans.add(c);
            }
            return ans;
        }

        private void heapInsert(int index) {
            while (comp.compare(heap.get(index), heap.get((index - 1) / 2)) < 0) {
                swap(index, (index - 1) / 2);
                index = (index - 1) / 2;
            }
        }

        private void heapify(int index) {
            int left = index * 2 + 1;
            while (left < heapSize) {
                int best = left + 1 < heapSize && comp.compare(heap.get(left + 1), heap.get(left)) < 0 ? (left + 1) : left;
                best = comp.compare(heap.get(best), heap.get(index)) < 0 ? best : index;
                if (best == index) {
                    break;
                }
                swap(best, index);
                index = best;
                left = index * 2 + 1;
            }
        }

        private void swap(int i, int j) {
            T o1 = heap.get(i);
            T o2 = heap.get(j);
            heap.set(i, o2);
            heap.set(j, o1);
            indexMap.put(o2, i);
            indexMap.put(o1, j);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}
