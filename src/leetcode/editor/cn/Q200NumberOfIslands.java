//Given an m x n 2D binary grid grid which represents a map of '1's (land) and
//'0's (water), return the number of islands. 
//
// An island is surrounded by water and is formed by connecting adjacent lands 
//horizontally or vertically. You may assume all four edges of the grid are all 
//surrounded by water. 
//
// 
// Example 1: 
//
// 
//Input: grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//Output: 1
// 
//
// Example 2: 
//
// 
//Input: grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//Output: 3
// 
//
// 
// Constraints: 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] is '0' or '1'. 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 1650 👎 0

package leetcode.editor.cn;

public class Q200NumberOfIslands {
    public static void main(String[] args) {
        Solution solution = new Q200NumberOfIslands().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
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
//leetcode submit region end(Prohibit modification and deletion)

}