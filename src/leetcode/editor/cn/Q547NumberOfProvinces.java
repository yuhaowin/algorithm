//There are n cities. Some of them are connected, while some are not. If city a
//is connected directly with city b, and city b is connected directly with city c,
// then city a is connected indirectly with city c. 
//
// A province is a group of directly or indirectly connected cities and no 
//other cities outside of the group. 
//
// You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the 
//iᵗʰ city and the jᵗʰ city are directly connected, and isConnected[i][j] = 0 
//otherwise. 
//
// Return the total number of provinces. 
//
// 
// Example 1: 
//
// 
//Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
//Output: 2
// 
//
// Example 2: 
//
// 
//Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
//Output: 3
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 200 
// n == isConnected.length 
// n == isConnected[i].length 
// isConnected[i][j] is 1 or 0. 
// isConnected[i][i] == 1 
// isConnected[i][j] == isConnected[j][i] 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 图 👍 763 👎 0

package leetcode.editor.cn;

public class Q547NumberOfProvinces {
    public static void main(String[] args) {
        Solution solution = new Q547NumberOfProvinces().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] help = new int[200];
        int[] roots = new int[200];

        public int findCircleNum(int[][] isConnected) {
            int num = isConnected.length;
            int size = isConnected.length;
            for (int i = 0; i < size; i++) {
                roots[i] = i;
            }
            for (int i = 0; i < size; i++) {
                for (int j = i + 1; j < size; j++) {
                    if (isConnected[i][j] == 1) {
                        int rootI = find(i);
                        int rootJ = find(j);
                        if (rootI != rootJ) {
                            roots[rootI] = rootJ;
                            num--;
                        }
                    }
                }
            }
            return num;
        }

        private int find(int x) {
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
    }
    //leetcode submit region end(Prohibit modification and deletion)
}