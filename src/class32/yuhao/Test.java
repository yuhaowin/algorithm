package class32.yuhao;

public class Test {

    public static void main(String[] args) {
        int N = 100;
        int V = 100;
        int testTime = 2000000;
        IndexTree tree = new IndexTree(N);
        Right test = new Right(N);
        System.out.println("test begin");
        for (int i = 0; i < testTime; i++) {
            int index = (int) (Math.random() * N) + 1;
            if (Math.random() <= 0.5) {
                int add = (int) (Math.random() * V);
                tree.add(index, add);
                test.add(index, add);
            } else {
                if (tree.sum(index) != test.sum(index)) {
                    System.out.println("Oops!");
                }
            }
        }
        System.out.println("test finish");
    }
}


class Right {

    private int size;

    private int[] nums;

    public Right(int size) {
        this.size = size + 1;
        nums = new int[this.size + 1];
    }

    public void add(int index, int d) {
        nums[index] += d;
    }

    public int sum(int index) {
        int ret = 0;
        for (int i = 1; i <= index; i++) {
            ret += nums[i];
        }
        return ret;
    }
}