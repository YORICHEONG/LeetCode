package byday.code_2021.code_11.day_02;

/**
 * @Description 给定一个数组 prices ，其中 prices[i] 是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）
 * @Author YORICHEONG
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2021-11-03
 */
public class MaxProfit {
    /**
     * 使用贪心的算法，在限制买卖的次数的情况下，如果今天的价格大于昨天的价格就买入
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int sumProfit = 0;
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            sumProfit += Math.max(0, prices[i] - prices[i - 1]);
        }

        return sumProfit;
    }
}
