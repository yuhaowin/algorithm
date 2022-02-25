package abc;

/**
 * @author yuhao
 * @version 5.11.0
 * @date 2021年06月27日 17:24:00
 */
public class Bisection {

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static boolean bisect(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return false;
        }

        int L = 0;
        int R = arr.length - 1;
        while (L <= R) {
            if (L == R){
                System.out.println(L);
            }
            int mid = (L + R) / 2;
            if (arr[mid] > num) {
                R = mid - 1;
            } else if (arr[mid] < num) {
                L = mid + 1;
            } else {
                return true;
            }
        }

        return false;
    }


    public static void main(String[] args) {
//        int[] source = {3, 2, 5, 3, 7, 1, 8, 4, 9, 3, 8, 4, 0, 3, 8};
        int[] source = {0,1,2,3,4,5,6};

        print(source);
        com.yuhaowin.Sort.insertSort(source);
        print(source);

        System.out.println(bisect(source,2));
    }
}
