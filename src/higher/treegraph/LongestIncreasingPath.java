package higher.treegraph;

/**
 * @description: 给定一个 m x n 整数矩阵 matrix ，找出其中 最长递增路径 的长度。
 * 对于每个单元格，你可以往上，下，左，右四个方向移动。 你 不能 在 对角线 方向上移动或移动到 边界外（即不允许环绕）。
 * @author YORICHEONG
 * @date 2021/7/26 10:24
 * @version 1.0
 */
public class LongestIncreasingPath {

    public int[][] direct = new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}};

    public int rows, columns;

    /**
     * @param: matrix
     * @description :
     * @return : int
     * @author : YORICHEONG
     * @date : 2021/7/26
     */
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        rows = matrix.length;
        columns = matrix[0].length;

        int[][] memoryMatrix = new int[rows][columns];

        int ans = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                ans = Math.max(ans,dfs(matrix, i, j, memoryMatrix));
            }
        }
        return ans;
    }
    
    /**
     * @param: matrix
     * @param: row
     * @param: columns
     * @param: memoryMatrix
     * @description :
     * @return : int
     * @author : YORICHEONG
     * @date : 2021/7/26
     */
    private int dfs(int[][] matrix, int row, int column, int[][] memoryMatrix) {
        //　如果记忆矩阵已有这个下标的值，就直接使用这个下标的值
        if(memoryMatrix[row][column] != 0) {
            return memoryMatrix[row][column];
        }
        ++memoryMatrix[row][column];
        for (int [] dir: direct) {
            int newRow = row + dir[0], newColumn = column + dir[1];
            if(newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < columns && matrix[newRow][newColumn] > matrix[row][column]) {
                memoryMatrix[row][column] = Math.max(memoryMatrix[row][column], dfs(matrix, newRow, newColumn, memoryMatrix) + 1);
            }
        }
        return memoryMatrix[row][column];
    }
}
