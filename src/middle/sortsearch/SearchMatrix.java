package middle.sortsearch;

/**
 * 2021-06-23 17:59:44
 * author：YORICHEONG
 */
public class SearchMatrix {
    /**
     * 使用行列判断法,很巧妙的方法
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length-1;
        int col = 0;

        while(row >= 0 && col < matrix[0].length) {
            if( matrix[row][col] > target) {
                row--;
            }else if(matrix[row][col] < target) {
                col++;
            }else {
                return true;
            }
        }

        return false;   
    }


    /**
     * 对行和列使用二分查找法来进行遍历
     */
    private void solution(){
        
    }
}
