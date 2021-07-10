package higher.treegraph;

/**
 * @author YORICHEONG
 * @data 2021-07-08 10:54:37
 * @description 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 */
public class Solve {
    /**
     * 
     * @param board
     */
    public void solve(char[][] board) {
        // 处理为空这样的极端情况
        if(board == null || board.length == 0) {
            return;
        }
        // 获取二维数组的行的长度和列的长度
        int row = board.length;
        int col = board[0].length;

        //然后对所有边界上的值为O的下标进行一个广度遍历
        for (int i = 0; i < row; i++) {
            dfs(board, i, 0);
            dfs(board, i, col-1);
        }

        for (int i = 0; i < col; i++) {
            dfs(board, 0, i);
            dfs(board, row-1, i);
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }        
                if(board[i][j] == '-') {
                    board[i][j] = 'O';
                }
            }
        }

        return;
    }
    
    private void dfs(char[][] board, int row, int col) {
        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] != 'O') {
            return;
        }   
        // 如果找到了符合的O，修改当前的值，然后以当前坐标为起点，然后进行广度优先遍历
        board[row][col] = '-';
        dfs(board, row-1, col);
        dfs(board, row+1, col);
        dfs(board, row, col+1);
        dfs(board, row, col-1);
        return;
    }
}
