package top100;

/**
 * @description: 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * @author YORICHEONG
 * @date 2021/9/15 10:05
 * @version 1.0
 */
public class MaxProfit {
    /**
     * @param: prices
     * @description : 使用的
     * @return : int
     * @author : YORICHEONG
     * @date : 2021/9/15
     */
    public int maxProfit(int[] prices) {
        if(prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        // 然后指定三种状态的初始值
        int f0 = -prices[0];
        int f1 = 0;
        int f2 = 0;

        for (int i = 1; i < prices.length; i++) {
            int newValue = Math.max(f0, f2 - prices[i]);
            int newValue2 = f0 + prices[i];
            int newVaule3 = Math.max(f1, f2);

            f0 = newValue;
            f1 = newValue2;
            f2 = newVaule3;
        }
        return Math.max(f1, f2);
    }

    public static void main(String[] args) {

        System.out.println(-1 << 3);
        System.out.println(-3 << 2);

    }
}
