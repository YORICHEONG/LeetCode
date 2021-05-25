package app.LeetCode.Base;
/**
 * 
 * 
给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。

你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像

 */
public class Rotate_image {
    /**
     * 可以先上下转换然后再对角线交换
     * @param matrix
     */
    public void rotate_01(int[][] matrix) {
        int length = matrix.length;
        /**
         * 先进行一个上下交换
         */
        for(int i = 0; i<length/2; i++){
            int temp[] = matrix[i];//对于二维数组的交换是一行一行的交换
            matrix[i] = matrix[length-i-1];
            matrix[length-i-1] = temp;
        }
        /**
         * 然后进行一个对称交换
         */
        for(int i = 0; i<length; i++){
            for(int j = i+1; j<length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
    public void rotate_02(int[][] matrix){
        int length = matrix.length;
        if(length==1){
            return;
        }
        int temp;
        for(int i = 0; i<=length/2; i++){
            /**
             * 首先进行对角线反转
             */
            for(int j = 0; j<length; j++){
                if(i==j){
                    continue;
                }if(i==1&&j==0){
                    continue;
                }else{
                    temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
        /**
        * 然后对每一行进行一个逆转
        */
        for(int i = 0; i<length; i++){
            for(int j = 0; j<length/2; j++){
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][length-j-1];
                matrix[i][length-j-1] = temp;
            }
        }
    }
}
