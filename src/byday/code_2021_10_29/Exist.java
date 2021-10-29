package byday.code_2021_10_29;

/**
 * @Description 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * @Author YORICHEONG yoricheong@gmail.com precent99@qq.com
 * @Date 2021/10/29 10:07
 * @Tags
 **/
public class Exist {

    public static void main(String[] args) {

    }

    /**
     * @Description: 广度搜索来解决问题
     * @Author: YORICHEONG 
     * @Date: 10:09 2021/10/29
     **/
    public boolean exist(char[][] board, String word) {
        char[] array = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, i, j, array, 0, array.length - 1)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * @Description: 广度遍历
     * @Author: YORICHEONG 
     * @Date: 10:16 2021/10/29
     **/
    private boolean dfs(char[][] board, int i, int j, char[] array, int currentLength, int targetLength) {
        // 首先进行下标的检查
        if(checkIndex(i, j, board)) {
            if(board[i][j] == array[currentLength]) {
                if(currentLength == targetLength) {
                    return true;
                }
                boolean result;
                board[i][j] += 255;
                result = dfs(board, i - 1, j, array, currentLength + 1, targetLength) ||
                        dfs(board, i + 1, j, array, currentLength + 1, targetLength) ||
                        dfs(board, i, j + 1, array, currentLength + 1, targetLength) ||
                        dfs(board, i, j - 1, array, currentLength + 1,  targetLength);
                board[i][j] -= 255;
                return result;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    
    /**
     * @Description: 用来检查下标
     * @Author: YORICHEONG 
     * @Date: 10:20 2021/10/29
     **/
    private boolean checkIndex(int i, int j, char[][] board) {
        return i >= 0 && i < board.length && j >= 0 && j < board[0].length;
    }
}
