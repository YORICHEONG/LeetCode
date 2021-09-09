package top100;

/**
 * @description: 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * 问总共有多少条不同的路径？
 * @author YORICHEONG
 * @date 2021/9/8 9:20
 * @version 1.0
 */
public class UniquePaths {

    //========================Method1 动态规划==================================

    public int uniquePaths(int m, int n) {
        // 首先将起始的临界的行和列设置成为零
        int[][] array = new int[m][n];
        for (int i = 0; i < m; i++) {
            array[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            array[0][i] = 1;
        }
        // 然后使用动态的形式来进行添加
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                array[i][j] = array[i-1][j] + array[i][j-1];
            }
        }
        // 然后返回这个动态数据中最大值
        return array[m-1][n-1];
    }

    //=========================Method2 数学公式=================================

    public int uniquePaths2(int m, int n) {

        return -1;
    }

    public static void main(String[] args) {
        // 使用位运算来判断是否为奇数
        int x = 3;
        if((x & 1) == 1) {
            System.out.println("偶数");
        }

        int a = 3;
        int b = 4;
        a = a^b;
        b = a^b;
        a = a^b;
        System.out.println(a + ":" + b);
    }

}
