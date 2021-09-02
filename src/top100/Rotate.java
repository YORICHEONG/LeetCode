package top100;

/**
 * @description: 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 * @author YORICHEONG
 * @date 2021/8/31 17:09
 * @version 1.0
 */
public class Rotate {
    /**
     * @param: matrix
     * @description : 采用反转的方法
     * @return : void
     * @author : YORICHEONG
     * @date : 2021/8/31
     */
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        // 首先上下反转
        for (int i = 0; i < length / 2; i++) {
            for (int j = 0; j < length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[length-i-1][j];
                matrix[length-i-1][j] = temp;
            }
        }
        // 然后对角反转
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

}
