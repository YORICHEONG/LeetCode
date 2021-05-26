package Middle.ArrayString;

public class SetZeroes {
    public void setZeroes(int[][] matrix) {
        boolean columnHasZero = false;
        boolean rowHasZero = false;
        //然后判断第一行或者是第一列是否有0
        for(int i =0; i<matrix[0].length;i++){
            if(matrix[0][i]==0){
                rowHasZero = true;
            }
        }

        for(int i=0; i<matrix.length; i++){
            if(matrix[i][0]==0){
                columnHasZero = true;
            }
        }

        for(int i =1; i<matrix.length;i++){
            for(int j = 1; j<matrix[i].length; j++){
                if(matrix[i][j] == 0 ){
                    //将这位置对应的第一行和第一列位置设为0
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int i =1; i<matrix.length;i++){
            for(int j = 1; j<matrix[i].length; j++){
                if(matrix[i][0]==0||matrix[0][j]==0){
                    matrix[i][j] = 0;
                }
            }
        }
        //然后根据第一行列是否为空来设置为空
        if(columnHasZero){
            for(int i = 0; i<matrix.length; i++){
                matrix[i][0] = 0;
            }
        }
        if(rowHasZero){
            for(int i = 0; i<matrix[0].length; i++){
                matrix[0][i] = 0;
            }
        }
    }
}
