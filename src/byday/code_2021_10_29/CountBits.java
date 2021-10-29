package byday.code_2021_10_29;

/**
 * @Description 给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。
 * @Author YORICHEONG yoricheong@gmail.com precent99@qq.com
 * @Date 2021/10/29 17:37
 * @Tags
 **/
public class CountBits {
    /**
     * @Description: 这个题应用到动态规划上主要用每个数的奇偶性来进行区分
     * @Author: YORICHEONG 
     * @Date: 17:56 2021/10/29
     **/
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i < n + 1 ; i++) {
            if(i % 2 == 0) {
                dp[i] = dp[i / 2];
            } else {
                dp[i] = dp[i / 2] + 1;
            }
        }
        return dp;
    }
}
