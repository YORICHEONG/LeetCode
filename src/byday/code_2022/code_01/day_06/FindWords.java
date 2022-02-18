package byday.code_2022.code_01.day_06;

import byday.code_2021.code_12.day_08.Trie;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author YORICHEONG yoricheong@gmail.com precent99@qq.com
 * @Date 2022/1/6 15:06
 * @Tags
 **/
public class FindWords {
    
    /**
     * @Description:
     * @Author: YORICHEONG 
     * @Date: 12:52 2022/1/6
     **/
    public List<String> findWords(char[][] board, String[] words) {
        // 首先是构建字典树
        Trie root = new Trie();
        // 插入数组
        for(String word : words) {
            root.insert(word);
        }
        // 构建结果集
        List<String> result = new ArrayList<>();
        // 矩阵初始化
        int m = board.length;
        int n = board[0].length;
        boolean[][] isVisited = new boolean[m][n];
        // 然后对整个数组来进行遍历
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 遍历方法
                find(board, isVisited, i, j, m, n, result, root);
            }
        }
        return result;
    }   
    
    /**
     * @Description:
     * @Author: YORICHEONG 
     * @Date: 15:11 2022/1/6
     **/
    private void find(char[][] board, boolean[][] isVisited, int i, int j, int m, int n, List<String> result, Trie root) {
        // 边界的判断，以及是否访问过
        if(i < 0 || i >= m || j < 0 || j >= n || isVisited[i][j]) {
            return;
        }
        root = root.container.get(board[i][j]);
        if(null == root) {
            return;
        }
        isVisited[i][j] = true;
        // 判断当前节点是否是一个单词
        if(root.isEnd) {
            result.add(root.value);
            root.isEnd = false;
        }
        // 然后对于周围的字符来进行遍历
        find(board, isVisited, i + 1, j, m, n, result, root);
        find(board, isVisited, i -1, j, m, n, result, root);
        find(board, isVisited, i, j + 1, m, n, result, root);
        find(board, isVisited, i, j - 1, m, n, result, root);

        // 最后修改节点为为访问状态
        isVisited[i][j] = false;
    }

}
/**
 * Given an m x n board of characters and a list of strings words, return all words on the board.
 * Each word must be constructed from letters of sequentially adjacent cells,
 * where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
 */