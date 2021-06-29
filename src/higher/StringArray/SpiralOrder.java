package higher.StringArray;
/**
 * @author YORICHEONG
 * @date 2021-06-28 12:44:14
 * @description Given an m x n matrix, return all elements of the matrix in spiral order
 */
import java.util.List;
import java.util.ArrayList;
public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<Integer>();

        if(matrix == null || matrix.length == 0) {
            return list;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;

        // 首先是来记录一下这个矩阵的层数
        int count = (Math.min(m,n)+1)/2;

        // 从外部向内部遍历，逐层的打印数据

        while(i < count) {
            // 添加上面的行数据
            for(int j = i; j < n-i; j++) {
                list.add(matrix[i][j]);
            }

            // 添加右边的列数据
            for(int j = i+1; j < m-i; j++) {
                list.add(matrix[j][(n-1)-i]);
            }

            // 添加下面的行数据
            for(int j = (n-1)-(i+1); j >= i && (m-1-i != i); j--) {
                list.add(matrix[(m-1)-i][j]);
            }
            
            // 添加左边的数据
            for(int j = (m-1)-(i+1); j >= i+1 && (n-1-i) != i; j--) {
                list.add(matrix[j][i]);
            }
            i++;
        }
        return list;
    }
}
