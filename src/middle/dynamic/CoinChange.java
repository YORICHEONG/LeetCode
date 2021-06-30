package middle.dynamic;

import java.util.Arrays;

/**
 * 2021-06-24 09:48:18
 * author：YORICHEONG
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
   你可以认为每种硬币的数量是无限的。

 */
public class CoinChange {
    private int res = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) {
            return 0;
        }
        //然后对硬币数组进行排序
        Arrays.sort(coins);
        //调用方法
        minCoin(coins, amount, coins.length-1, 0);
        return res == Integer.MAX_VALUE?-1:res;
    }

    private void minCoin(int[] coins, int amount, int index, int count) {
        if(amount == 0) {
            res = Math.min(res,count);
            return;
        }
        if(index < 0) {
            return;
        }
        // i是当前大小的货币，amount才可以组成
        // 
        for(int i = amount/coins[index]; i >= 0 && i+count < res; i--) {
            minCoin(coins, amount-(i*coins[index]), index-1, count+i);
        }
    }

    /**
     * 使用动态的规划的方法
     * @param conins
     * @param amount
     * @return
     */
    public int solution(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
