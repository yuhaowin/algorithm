package leetcode.editor.en.followup;

public class Q48RotateImageFollowUp {

    public static void main(String[] args) {
        Q48RotateImageFollowUp imageFollowUp = new Q48RotateImageFollowUp();
        String[][] build = imageFollowUp.build(20);
        for (String[] items : build) {
            for (String item : items) {
                if (item == null) {
                    System.out.print("   ");
                } else {
                    System.out.print(item + "  ");
                }
            }
            System.out.println();
        }
    }

    private String[][] build(int N) {
        String[][] matrix = new String[N][N];
        int a = 0;
        int b = 0;
        int x = N - 1;
        int y = N - 1;
        while (a <= x) {
            process(matrix, a, b, x, y);
            a += 2;
            b += 2;
            x -= 2;
            y -= 2;
        }
        return matrix;
    }

    private void process(String[][] matrix, int a, int b, int x, int y) {
        int len = x - a;
        for (int i = 0; i < len; i++) {
            matrix[a][b + i] = "*";
        }

        int xx = y - b;
        for (int i = 0; i < xx; i++) {
            matrix[a + i][y] = "*";
        }

        for (int i = 0; i < len; i++) {
            matrix[x][y - i] = "*";
        }

        for (int i = 2; i < xx; i++) {
            matrix[a + i][b + 1] = "*";
        }
    }
}
