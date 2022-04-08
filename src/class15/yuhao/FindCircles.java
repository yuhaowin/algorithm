package class15.yuhao;

public class FindCircles {

    public static void main(String[] args) {

    }

    public int findCircles(int[][] M) {
        int N = M.length;
        UnionFind unionFind = new UnionFind(N);
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (M[i][j] == 1) {
                    unionFind.union(i, j);
                }
            }
        }
        return unionFind.size;
    }

    //------------------------------------------------------------------------------------------------------------------

    static class UnionFind {
        int[] roots;
        int[] capacity;
        int[] help;
        int size;

        public UnionFind(int N) {
            roots = new int[N];
            capacity = new int[N];
            help = new int[N];
            size = N;
            for (int i = 0; i < N; i++) {
                roots[i] = i;
                capacity[i] = 1;
            }
        }

        public int find(int x) {
            int count = 0;
            while (x != roots[x]) {
                help[count] = x;
                count++;
                x = roots[x];
            }
            for (int i = 0; i < count; i++) {
                roots[help[i]] = x;
            }
            return x;
        }

        public void union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            if (rootA != rootB) {
                int capacityA = capacity[rootA];
                int capacityB = capacity[rootB];
                if (capacityA < capacityB) {
                    roots[rootA] = rootB;
                    capacity[rootB] += capacityA;
                } else {
                    roots[rootB] = rootA;
                    capacity[rootA] += capacityB;
                }
                size--;
            }
        }

        public int size() {
            return size;
        }
    }
}
