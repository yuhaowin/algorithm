package class29.yuhao;

/**
 * 蓄水池算法
 * 解决的问题：
 * 假设有一个源源吐出不同球的机器，
 * 只有装下10个球的袋子，每一个吐出的球，要么放入袋子，要么永远扔掉如何做到机器吐出每一个球之后，所有吐出的球都等概率被放进袋子里
 */
public class RandomBox {

    /**
     * 第一次登陆的用户可以参与抽奖，活动时间是 1号到2号 一整天
     * 中奖的概率是等概率的，共有100名
     * <p>
     * 如，某一个用户是第 i 号登陆的，以 100/i 的概率决定是否入奖池,
     * 然后在100 的奖池中等概率剔除一个
     */
    public static void main(String[] args) {
        // bag 的 capacity
        int capacity = 10;
        // 0-100 依次加入 bag 中
        int numStream = 100;
        // 测试的次数
        int testTimes = 50000;
        int[] counts = new int[numStream + 1];
        for (int i = 0; i < testTimes; i++) {
            RandomBox box = new RandomBox(capacity);
            for (int num = 0; num <= numStream; num++) {
                box.add(num);
            }
            int[] ans = box.choices();
            for (int j = 0; j < ans.length; j++) {
                counts[ans[j]]++;
            }
        }
        for (int i = 0; i < counts.length; i++) {
            System.out.println(i + " times : " + counts[i]);
        }
    }

    //------------------------------------------------------------------------------------------------------------------

    private int[] bag;
    private int capacity;
    private int size;

    public RandomBox(int capacity) {
        this.bag = new int[capacity];
        this.capacity = capacity;
        this.size = 0;
    }

    public void add(int num) {
        size++;
        if (size <= capacity) {
            bag[size - 1] = num;
        } else {
            if (random(size) <= capacity) {
                bag[random(capacity) - 1] = num;
            }
        }
    }

    public int[] choices() {
        int[] ans = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            ans[i] = bag[i];
        }
        return ans;
    }

    private int random(int max) {
        return (int) (Math.random() * max) + 1;
    }
}
