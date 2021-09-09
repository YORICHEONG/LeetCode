package top100;

import java.util.HashMap;

/**
 * @description: 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * ["C","A","A"]
 * ["A","A","A"]
 * ["B","C","D"]
 * @author YORICHEONG
 * @date 2021/9/9 10:27
 * @version 1.0
 */
public class ExistWord {
    /**
     * @param: board
     * @param: word
     * @description : 查找一个单词是否存在
     * @return : boolean
     * @author : YORICHEONG
     * @date : 2021/9/9
     */
    public boolean exist(char[][] board, String word) {
        char[] array = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(dfs(board, i, j, array, 0, word.length() - 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @param: board
     * @param: i
     * @param: j
     * @param: word
     * @param: index
     * @param: target
     * @description : 
     * @return : boolean
     * @author : YORICHEONG
     * @date : 2021/9/9
     */
    private boolean dfs(char[][] board, int i, int j, char[] word, int index, int target) {
        if(checkIndex(i, j, board)) {
            if(board[i][j] == word[index]) {
                if(index == target) {
                    return true;
                } else {
                    board[i][j] += 255;
                    boolean result =
                            dfs(board, i+1, j, word, index + 1, target) ||
                            dfs(board, i-1, j, word, index + 1, target) ||
                            dfs(board, i, j-1, word, index + 1, target) ||
                            dfs(board, i, j+1, word,index + 1, target);
                    board[i][j] -= 255;

                    return result;
                }
            } else {
                return false;
            }
        }
        return false;
    }
    
    /**
     * @param: i
     * @param: j
     * @param: board
     * @description :
     * @return : boolean
     * @author : YORICHEONG
     * @date : 2021/9/9
     */
    private boolean checkIndex(int i, int j, char[][] board) {
        if (i >= 0 && i < board.length && j >= 0 && j < board[0].length) {
            return true;
        }
        return false;
    }
}
