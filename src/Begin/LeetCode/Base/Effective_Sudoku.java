package Begin.LeetCode.Base;
/**
 * 请你判断一个 9x9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可
 * 数字 1-9 在每一行只能出现一次。
数字 1-9 在每一列只能出现一次。
数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）

一个有效的数独（部分已被填充）不一定是可解的。
只需要根据以上规则，验证已经填入的数字是否有效即可
 */
public class Effective_Sudoku {

    public boolean isValidSudoku(char[][] board) {
        int length = board.length;
        
        int[][] line = new int[length][length];
        int[][] column = new int[length][length];
        int[][] cell = new int[length][length];
        
        for(int i = 0; i<length; i++){
            for(int j = 0; j<length; j++){
                //如果没有数字就直接跳过
                if(board[i][j]=='.'){
                    continue;
                }
                //num是当前格子的数,用做下标使用
                int num = board[i][j]-'0'-1;
                //计算的是第几个单元格，就是对于当前的i,j对应的下标
                int k = i/3*3+j/3;
                if(line[i][num]!=0||column[j][num]!=0||cell[k][num]!=0){
                    return false;
                }
                line[i][num]=column[j][num]=cell[k][num]=1;
            } 
        }
        return true;
    }
}
