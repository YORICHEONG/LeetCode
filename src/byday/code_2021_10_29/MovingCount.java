package byday.code_2021_10_29;

import app.base.MoveZeroArray;

/**
 * @Description 地上有一个m行n列的方格，从坐标 [0, 0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
 * 也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，
 * 因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？

 * @Author YORICHEONG
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2021-10-29
 */
public class MovingCount {

    public static void main(String[] args) {
        System.out.println(new MovingCount().movingCount(2,3,1));
    }

    /**
     * 使用的是广度搜索方法来进行测试
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int movingCount(int m, int n, int k) {
        boolean[][] isVisited = new boolean[m][n];
        return dfs(0, 0, k, m, n, isVisited);
    }

    private int dfs(int i, int j, int k, int m, int n,boolean[][] isVisited) {
        if( i >= m || j >= n || i < 0 || j < 0 || isVisited[i][j] || (i % 10 + i / 10 + j % 10 + j / 10) > k) {
            return 0;
        } else {
            isVisited[i][j] = true;
            return dfs(i + 1, j, k, m, n, isVisited) + dfs(i - 1, j, k, m, n, isVisited) +
                    dfs(i, j - 1, k, m, n, isVisited) + dfs(i, j + 1, k, m, n, isVisited) + 1;
        }

    }

}
