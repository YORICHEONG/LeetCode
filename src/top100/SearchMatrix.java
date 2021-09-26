package top100;

/**
 * @description: 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * @author YORICHEONG
 * @date 2021/9/14 15:27
 * @version 1.0
 */
public class SearchMatrix {
    /**
     * @param: matrix
     * @param: target
     * @description : 使用减治的方法来进行搜素,从最左下角来进行遍历查找
     * @return : boolean
     * @author : YORICHEONG
     * @date : 2021/9/14
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0) {
            return false;
        }
        int high = matrix.length;
        int wight = matrix[0].length;

        int i = high - 1;
        int j = 0;
        while(i >= 0 && j < wight) {
            if(matrix[i][j] == target) {
                return true;
            }
            else if(target > matrix[i][j]) {
                j = j + 1;
            } else {
                i = i - 1;
            }
        }
        return false;
    }
}
