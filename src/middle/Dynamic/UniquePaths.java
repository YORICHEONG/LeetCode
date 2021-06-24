package middle.Dynamic;
/**
 * 2021-06-24 09:26:26
 * author:YORICHEONG
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        //首相创建一个二维数组，然后设置边界值
        int[][] array = new int[m][n];
        for(int i = 0; i<m; i++) {
            array[i][0] = 1;
        }
        for(int i = 0; i<n; i++) {
            array[0][i] = 1;
        }

        //使用二维数组中的每个位置记录的是就是从初始点到这个位置的道路的个数

        for(int i = 1; i<m; i++){
            for(int j = 1; j<n; j++) {
                //动态的记录到每个点的有效路径数量
                array[i][j] = array[i-1][j]+array[i][j-1];
            }
        }
        
        return array[m-1][n-1];
    }

    /**
     * 使用数学的公式的方法来计算一个二维数组中路线的条数
     * @param m
     * @param n
     * @return
     */
    public int solution(int m, int n) {
        long ans = 1;
        for (int x = n, y = 1; y < m; ++x, ++y) {
            ans = ans * x / y;
        }
        return (int) ans;
    }
}
