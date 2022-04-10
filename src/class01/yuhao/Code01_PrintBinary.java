package class01.yuhao;

/**
 * @author yuhao
 * @version 5.11.0
 * @date 2021年07月05日 23:48:00
 */
public class Code01_PrintBinary {

    /**
     * & 运算
     * 打印 int 的二进制数
     */
    public static void print(int num) {
        for (int i = 31; i >= 0; i--) {
            // 0&0=0; 0&1=0; 1&0=0; 1&1=1; 两位同时为“1”，结果才为“1”，否则为0
            System.out.print((num & (1 << i)) == 0 ? "0" : "1");
        }
        System.out.println();
    }

    /**
     * http://www.ruanyifeng.com/blog/2021/01/_xor.html
     * ^ 运算
     * XOR 主要用来判断两个值是否不同。两个值不同 -> 1, 两个值相同 -> 0
     * 0 ^ 0 = 0
     * 0 ^ 1 = 1
     * 1 ^ 0 = 1
     * 1 ^ 1 = 0
     */
    public static int missingNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = i+1 ^ nums[i];
            result ^= temp;
        }
        return result ^ nums.length +1;
    }


    public static void main(String[] args) {
        System.out.println(6^7);
        System.out.println(missingNumber(new int[]{1,2,3,4,5,7}));
    }
}

