package higher.stringarray;/**
 * @Description
 * @author YORICHEONG
 * @create 2021-06-30 10:21
 */

/**
 * @description: TODO
 * @author YORICHEONG
 * @date 2021/6/30 10:21
 * @version 1.0
 * @description
 * 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞都具有一个初始状态：1 即为活细胞（live），或 0 即为死细胞（dead）。
 * 每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
 * 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
 * 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
 * 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
 * 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
 * 下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。给你 m x n 网格面板 board 的当前状态，返回下一个状态。
 */
public class GameOfLife {
    
    // 设置下标的移动的位置
    private int[][] moveArray = {
        {0,1},
        {1,0},
        {-1,0},
        {0,-1},
        {1,1},
        {-1,-1},
        {1,-1},
        {-1,1}
    };

    /**
     * @description:
     * @param: [int[][]] [board] 
     * @return: void
     * @author YORICHEONG
     * @date: 2021/6/30 10:22
     */
    public void gameOfLife(int[][] board) {
        int[][] countArray = getCountArray(board);
        // 通过这个countArray来修改状态
        moveAlive(board,countArray);
    }
    
    /**
     * @description: 
     * @param: [int[][], int[][]] [board, countArray] 
     * @return: void
     * @author YORICHEONG
     * @date: 2021/6/30 10:56
     */
    private void moveAlive(int[][] board,int[][] countArray) {
        for(int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                moveRule(board, i, j, countArray);
            }
        }
    }
    
    /**
     * @description:
     * @param: [int[][], int, int, int[][]] [board, i, j, countArray] 
     * @return: void
     * @author YORICHEONG
     * @date: 2021/6/30 10:56
     */
    private void moveRule(int[][] board,int i, int j,int[][] countArray) {
        int aliveCount = countArray[i][j];

        if(aliveCount == 3) {
            board[i][j] = 1;
            return;
        } else if(aliveCount < 2 && board[i][j] == 1) {
            board[i][j] = 0;
            return;
        } else if(aliveCount > 3 && board[i][j] == 1) {
            board[i][j] = 0;
            return;
        } else {
            if(aliveCount == 2 && board[i][j] == 1) {
                board[i][j] = 1;
                return;
            } else {
                board[i][j] = 0;
                return;
            }
        }
    }
    /**
     * @description:
     * @param: [int[][]] [board] 
     * @return: int[][]
     * @author YORICHEONG
     * @date: 2021/6/30 10:43
     */
    private int[][] getCountArray(int[][] board) {
        int[][] countArray = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // 然后来进行判断
                int count = check(board, i, j);
                countArray[i][j] = count;
            }
        }
        return countArray;
    }
    /**
     * @description:
     * @param: [int[][], int, int, int[][]] [board, i, j, moveIndex] 
     * @return: int
     * @author YORICHEONG
     * @date: 2021/6/30 10:33
     */
    private int check(int[][] board, int i,int j) {
        int count = 0;
        for(int x = 0; x < 8; x++) {
            int currentA = -1;
            int currentB = -1;
            currentA = i + moveArray[x][0];
            currentB = j + moveArray[x][1];
            if(currentA >= 0 && currentA < board.length && currentB < board[0].length && currentB >= 0 && board[currentA][currentB] == 1) {
                count++;
            }
        }
        return count;
    }
}
