package byday.code_2021_10_28;

/**
 * @Description 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * @Author YORICHEONG yoricheong@gmail.com precent99@qq.com
 * @Date 2021/10/28 14:27
 * @Tags
 **/
public class FindNumberIn2DArray {
    /**
     * @Description: 从右上角来进行判断
     * @Author: YORICHEONG
     * @Date: 14:28 2021/10/28
     **/
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) {
            return false;
        }
        // 从整个二维数组右上角的角度来进行处理
        // 创建一个递归方法来进行处理
        return dfs(matrix, 0, matrix[0].length - 1, target);
    }
    
    /**
     * @Description:
     * @Author: YORICHEONG 
     * @Date: 14:50 2021/10/28
     **/
    private boolean dfs(int[][] matrix, int beginI, int beginJ, int target) {
        if(beginI < matrix.length && beginJ >= 0) {
            if(matrix[beginI][beginJ] == target) {
                return true;
            } else if(matrix[beginI][beginJ] < target) {
                return dfs(matrix, beginI + 1, beginJ, target);
            } else {
                return dfs(matrix, beginI, beginJ - 1, target);
            }
        } else {
            return false;
        }
    }
}
