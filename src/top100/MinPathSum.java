package top100;

/**
 * @description: 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 * [1,3,1]
 * [1,5,1]
 * [4,2,1]
 * @author YORICHEONG
 * @date 2021/9/8 14:57
 * @version 1.0
 */
public class MinPathSum {
    //==============================Method 1==========================================
    /**
     * @param: grid
     * @description : 动态规划算法查找最短路径
     * @return : int
     * @author : YORICHEONG
     * @date : 2021/9/8
     */
    public int minPathSum(int[][] grid) {
        int width = grid[0].length;
        int height = grid.length;
        if(width == 0 || height == 0) {
            return 0;
        }
        // 对已创建的数组，首先将两条边进行初始化
        for (int i = 1; i < height; i++) {
            grid[i][0] += grid[i-1][0];
        }
        for (int i = 1; i < width; i++) {
            grid[0][i] += grid[0][i-1];
        }
        for (int i = 1; i < height; i++) {
            for (int j = 1; j < width; j++) {
                grid[i][j] += Math.min(grid[i-1][j],grid[i][j-1]);
            }
        }

        return grid[height-1][width-1];
    }
}
