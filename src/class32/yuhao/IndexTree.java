package class32.yuhao;

/**
 * 一维 Index Tree
 */
public class IndexTree {

    private int size;

    private int[] tree;


    public IndexTree(int size) {
        this.size = size;
        // 0 位置弃而不用,初始化所有的值都是 0
        tree = new int[size + 1];
    }

    // index & -index : 提取出index最右侧的1出来
    // index :           0011001000
    // index & -index :  0000001000
    public void add(int index, int value) {
        // 当 index 位置的数发生变化，需要修改 index 以及右边所有受到牵连的值
        while (index <= size) {
            tree[index] += value;
            index += index & -index;
        }
    }

    // 1~index 累加和是多少？
    public int sum(int index) {
        int result = 0;
        while (index > 0) {
            result += tree[index];
            index -= index & -index;
        }
        return result;
    }
}
