package middle.Backtrace;
import java.util.*;

/**
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。

单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。

 */


public class Exist {
    private int width;
    private int length;
    private int wordLength;
    public boolean exist(char[][] board, String word) {
        width = board.length;
        length = board[0].length;
        wordLength = word.length();

        boolean[][] isTrue = new boolean[width][length];
        for(int i = 0; i<width; i++){
            for(int j = 0; j<length; j++){
                if(dfs(board, i, j, word, 0, isTrue)){
                    return true;
                }
            }
        }
        return false;
    } 
    private boolean dfs(char[][] board,int i,int j,String word,int index,boolean[][] isTrue){
        //首先进行数组下标的越界的判断，二维数组当前的位置的值是否是符合当前index的word
        if(i<0||j<0||i>=width||j>=length||board[i][j]!=word.charAt(index)||isTrue[i][j]){
            return false;
        }else if(index+1 == wordLength){
            return true;
        }   
        //当前二维数组中的字符是符合此时word单词中的index下标的字符的
        isTrue[i][j] = true;
        //然后判断的四周的下标的字符是否符合的前进一位的字符
        if(dfs(board, i+1, j, word, index+1, isTrue)){
            return true;
        }
        if(dfs(board, i-1, j, word, index+1, isTrue)){
            return true;
        }
        if(dfs(board, i, j+1, word, index+1, isTrue)){
            return true;
        }
        if(dfs(board, i, j-1, word, index+1, isTrue)){
            return true;
        }
        isTrue[i][j]= false;
        return false;
    }   
}
