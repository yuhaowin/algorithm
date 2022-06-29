package class31.yuhao;

public class SegmentTree {

    private int max;
    /**
     * origin[]为原序列的信息从0开始，但在 origin 里是从1开始的
     */
    private int[] origin;
    /**
     * sum[]模拟线段树维护区间和
     */
    private int[] sum;
    /**
     * lazy[]为累加和懒惰标记
     */
    private int[] lazy;
    /**
     * change[]为更新的值
     */
    private int[] change;
    /**
     * update[]为更新慵懒标记
     */
    private boolean[] update;

    public SegmentTree(int[] array) {
        max = array.length + 1;
        origin = new int[max]; // origin[0] 不用 从1开始使用
        for (int i = 1; i < max; i++) {
            origin[i] = array[i - 1];
        }
        sum = new int[max << 2]; // 用来支持脑补概念中，某一个范围的累加和信息
        lazy = new int[max << 2]; // 用来支持脑补概念中，某一个范围沒有往下傳遞的纍加任務
        change = new int[max << 2]; // 用来支持脑补概念中，某一个范围有没有更新操作的任务
        update = new boolean[max << 2]; // 用来支持脑补概念中，某一个范围更新任务，更新成了什么
    }

    /**
     * 构建线段树
     */
    public void build(int l, int r, int rt) {
        if (l == r) {
            sum[rt] = origin[l];
            return;
        }
        int mid = (l + r) / 2;
        build(l, mid, rt * 2);
        build(mid + 1, r, rt * 2 + 1);
        pushUp(rt);
    }

    /**
     * L-R, C 任务:在 L-R 范围上每一个元素都加上 C
     * 当前在 l-r 范围上的累加和是 sum[rt]
     */
    public void add(int L, int R, int C,
                    int l, int r, int rt) {
        // 任务如果把此时的范围全包了！
        if (L <= l && r <= R) {
            sum[rt] += C * (r - l + 1);
            lazy[rt] += C;
            return;
        }

        // 任务没有把你全包！
        int mid = (l + r) / 2;
        // 把之前的任务结算
        pushDown(rt, (mid - l) + 1, r - mid);

        // 任务需要发给左边
        if (L <= mid) {
            add(L, R, C, l, mid, rt << 1);
        }

        // 任务需要发给右边
        if (R > mid) {
            add(L, R, C, mid + 1, r, rt << 1 | 1);
        }
        pushUp(rt);
    }

    /**
     * L-R, C 任务:在 L-R 范围上每一个元素都变成 C
     */
    public void update(int L, int R, int C,
                       int l, int r, int rt) {
        if (L <= l && r <= R) {
            update[rt] = true;
            change[rt] = C;
            // 个数 * C
            sum[rt] = C * (r - l + 1);
            lazy[rt] = 0;
            return;
        }
        // 当前任务躲不掉，无法懒更新，要往下发
        int mid = (l + r) / 2;
        pushDown(rt, (mid - l) + 1, r - mid);
        if (L <= mid) {
            update(L, R, C, l, mid, rt << 1);
        }
        if (R > mid) {
            update(L, R, C, mid + 1, r, rt << 1 | 1);
        }
        pushUp(rt);
    }

    /**
     * 1~6 累加和是多少？ 1~8 rt
     */
    public long query(int L, int R,
                      int l, int r, int rt) {
        if (L <= l && r <= R) {
            return sum[rt];
        }
        int mid = (l + r) >> 1;
        pushDown(rt, mid - l + 1, r - mid);
        long ans = 0;
        if (L <= mid) {
            ans += query(L, R, l, mid, rt << 1);
        }
        if (R > mid) {
            ans += query(L, R, mid + 1, r, rt << 1 | 1);
        }
        return ans;
    }

    //------------------------------------------------------------------------------------------------------------------

    /**
     * 计算 rt 位置的累加和
     */
    private void pushUp(int rt) {
        sum[rt] = sum[2 * rt] + sum[2 * rt + 1];
    }

    /**
     * 之前的，所有懒增加，和懒更新，从父范围，发给左右两个子范围
     *
     * @param rt
     * @param ln 表示左子树元素结点个数
     * @param rn 表示右子树结点个数
     */
    private void pushDown(int rt, int ln, int rn) {
        // 需要先处理 update 再处理 add
        if (update[rt]) {
            update[rt << 1] = true;
            update[rt << 1 | 1] = true;
            change[rt << 1] = change[rt];
            change[rt << 1 | 1] = change[rt];
            lazy[rt << 1] = 0;
            lazy[rt << 1 | 1] = 0;
            sum[rt << 1] = change[rt] * ln;
            sum[rt << 1 | 1] = change[rt] * rn;
            update[rt] = false;
        }
        // 把任务分发给左右两个孩子，自己清空。
        if (lazy[rt] != 0) {
            lazy[rt << 1] += lazy[rt];
            sum[rt << 1] += lazy[rt] * ln;
            lazy[rt << 1 | 1] += lazy[rt];
            sum[rt << 1 | 1] += lazy[rt] * rn;
            lazy[rt] = 0;
        }
    }
}
