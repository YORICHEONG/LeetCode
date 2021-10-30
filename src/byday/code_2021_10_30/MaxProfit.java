package byday.code_2021_10_30;

/**
 * @Description
 * @Author YORICHEONG yoricheong@gmail.com precent99@qq.com
 * @Date 2021/10/30 13:01
 * @Tags
 **/
public class MaxProfit {
    /**
     * @Description: 使用贪心算法来进行
     * @Author: YORICHEONG 
     * @Date: 13:01 2021/10/30
     **/
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        // 这个是最初的成本
        int buy = prices[0] + fee;
        int profit = 0;
        for (int i = 1; i < n; i++) {
            if(prices[i] + fee < buy) {
                buy = prices[i] + fee;
            } else if(prices[i] > buy) {
                profit += prices[i] - buy;
                buy = prices[i];
            }
        }
        return profit;
    }
}
