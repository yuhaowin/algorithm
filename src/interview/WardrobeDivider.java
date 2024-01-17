package interview;

import java.util.ArrayList;
import java.util.List;

public class WardrobeDivider {

    public static void main(String[] args) {
        int[] zs = new int[]{50, 60, 1000};
        int n = zs.length;
        WardrobeDivider divider = new WardrobeDivider();
        List<List<Integer>> result = divider.divideWardrobe(n, zs);
        result.forEach(ans -> {
            ans.forEach(it -> System.out.print(it + " "));
            System.out.println();
        });
    }

    public List<List<Integer>> divideWardrobe(int n, int[] zs) {
        int totalHeight = 2000;
        List<List<Integer>> results = new ArrayList<>();
        backtrack(n, zs, new ArrayList<>(), results, totalHeight, 0);
        return results;
    }

    private void backtrack(int n, int[] zs, List<Integer> current, List<List<Integer>> results, int totalHeight, int level) {
        if (current.size() == n) {
            if (isValidPartition(zs, current, totalHeight, n)) {
                results.add(new ArrayList<>(current));
            }
            return;
        }

        for (int i = level; i < n; i++) {
            current.add(i + 1);
            backtrack(n, zs, current, results, totalHeight, i + 1);
            current.remove(current.size() - 1);
        }
    }

    private boolean isValidPartition(int[] zs, List<Integer> current, int totalHeight, int n) {
        int partitionHeight = totalHeight / (n + 1);
        int heightSoFar = 0;
        for (int i = 0; i < current.size(); i++) {
            heightSoFar += zs[current.get(i) - 1];
            if (heightSoFar != partitionHeight * (i + 1)) {
                return true;
            }
        }
        return true;
    }
}

