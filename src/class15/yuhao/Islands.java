package class15.yuhao;

/**
 * 岛问题
 * 给定一个二维数组 matrix，里面的值不是 1 就是 0，
 * 上、下、左、右相邻的1认为是一片岛，
 * 返回 matrix 中岛的数量
 */
public class Islands {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        int num = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == '1') {
                    process(grid, i, j);
                    num++;
                }
            }
        }
        return num;
    }

    private void process(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '2';
        process(grid, i - 1, j);
        process(grid, i + 1, j);
        process(grid, i, j - 1);
        process(grid, i, j + 1);
    }
}
