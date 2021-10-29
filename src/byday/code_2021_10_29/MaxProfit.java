package byday.code_2021_10_29;

import java.util.Arrays;

/**
 * @Description 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 *
 * @Author YORICHEONG yoricheong@gmail.com precent99@qq.com
 * @Date 2021/10/29 16:43
 * @Tags
 **/
public class MaxProfit {
    /**
     * @Description: 使用从后到前来确定状态的动态规划方法来进行
     * @Author: YORICHEONG 
     * @Date: 16:43 2021/10/29
     **/
    public int maxProfit(int[] prices) {
        int[] dp = new int[prices.length];
        dp[prices.length - 1] = 0;
        int maxValue = 0;
        for (int i = prices.length - 2; i >= 0 ; i--) {
            int profit = prices[i + 1] - prices[i];
            dp[i] = Math.max(profit, profit + dp[i + 1]);
            maxValue = Math.max(maxValue, dp[i]);
        }
        if(maxValue < 0) {
            return 0;
        } else {
            return maxValue;
        }
    }
    
    /**
     * @Description: 使用从前面开始的动态规划
     * @Author: YORICHEONG 
     * @Date: 17:14 2021/10/29
     **/
    public int maxProfit2(int[] prices) {
        if(prices.length <= 1) {
            return 0;
        }
        int min = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length ; i++) {
            max = Math.max(max, prices[i] - min);
            min = Math.min(min, prices[i]);
        }

        return max;
    }


    public static void main(String[] args) {
        System.out.println(new MaxProfit().maxProfit(new int[] {7,1,5,3,6,4}));
    }


}

// 5 6 4