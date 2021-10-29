package byday.code_2021_10_29;

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

    private int count = 0;
    /**
     *
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int movingCount(int m, int n, int k) {
        return 0;
    }

    private void dfs(int i, int j, int k, int m, int n) {
        if(checkIndex(i, j, m, n)) {
            if(isEnable(i, j, k)) {
                count ++;
            }


        } else {
            return;
        }
    }

    private boolean checkIndex(int i, int j, int m, int n) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }

    private boolean isEnable(int i, int j, int k) {
        int sumI = getSum(i);
        int sumJ = getSum(j);
        int allSum = sumI + sumJ;

        return allSum > k ? false : true;
    }


    /**
     *
     * @param number
     * @return
     */
    private int getSum(int number) {
        int nextValue = 0;
        int sum = 0;
        int multiplyValue = 0;

        while(number > 10) {
            nextValue = number / 10;
            multiplyValue = number % 10;

            sum += multiplyValue;
            number = nextValue;
        }
        sum += number;

        return sum;
    }
}
