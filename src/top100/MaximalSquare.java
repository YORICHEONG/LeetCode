package top100;

/**
 * @description: 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 * @author YORICHEONG
 * @date 2021/9/13 9:50
 * @version 1.0
 */
public class MaximalSquare {
    
    /**
     * @param: matrix
     * @description : 使用动态规划的方法来进行判断
     * @return : int
     * @author : YORICHEONG
     * @date : 2021/9/13
     */
    public int maximalSquare(char[][] matrix) {
        int matrixH = matrix.length;
        if(matrixH < 1) {
            return 0;
        }
        int matrixL = matrix[0].length;
        int max = 0;
        int[][] dp = new int[matrixH + 1][matrixL + 1];

        for (int i = 1; i <= matrixH; i++) {
            for (int j = 1; j <= matrixL; j++) {
                // 在这里使用动态规划的方法
                if(matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                    max = Math.max(dp[i][j], max);
                }
            }
        }
        return max * max;
    }
}
