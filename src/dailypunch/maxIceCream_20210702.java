package dailypunch;/**
 * @Description
 * @author YORICHEONG
 * @create 2021-07-02 9:33
 */

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 夏日炎炎，小男孩 Tony 想买一些雪糕消消暑。
 * 商店中新到 n 支雪糕，用长度为 n 的数组 costs 表示雪糕的定价，其中 costs[i] 表示第 i 支雪糕的现金价格。Tony 一共有 coins 现金可以用于消费，他想要买尽可能多的雪糕。
 * 给你价格数组 costs 和现金量 coins ，请你计算并返回 Tony 用 coins 现金能够买到的雪糕的 最大数量 。
 *
 * 输入：costs = [1,3,2,4,1], coins = 7
 * 输出：4
 * 解释：Tony 可以买下标为 0、1、2、4 的雪糕，总价为 1 + 3 + 2 + 1 = 7
 *
 * 输入：costs = [10,6,8,7,7,8], coins = 5
 * 输出：0
 * 解释：Tony 没有足够的钱买任何一支雪糕。
 * @author YORICHEONG
 * @date 2021/7/2 9:33
 * @version 1.0
 */
public class maxIceCream_20210702 {
    /**
     * @description: 学习网上的非贪心和排序取值的方法
     * @param: [int[], int] [costs, coins] 
     * @return: int
     * @author YORICHEONG
     * @date: 2021/7/2 10:04
     */
    public int maxIceCream(int[] costs, int coins) {
        // 冰淇淋价格数组的长度
        int n = costs.length;
        int i = 0;
        int x = 0;
        int res = 100000;
        long d = 0;

        // 获得冰淇淋价格数组中的最大值和最小值
        for(; i < n; i++) {
            d += costs[i];
            if (costs[i] > x) {
                // 最大值
                x = costs[i];
            }
            if (costs[i] < res) {
                // 最小值
                res = costs[i];
            }
        }

        // 如果已有的资金大于所有的冰淇淋的价格之合，那么直接返回整个冰淇淋数组的长度
        if(coins >= d){
            return n;
        }

        // 如果最贵的冰淇淋价格和最便宜的冰淇淋价格一样，那么直接返回已有的资金除以冰淇淋的单价
        if(x == res) {
            return coins/x;
        }

        // 统计每种价格冰淇淋的数量
        byte[] freq = new byte[x+1];
        for(int cost : costs) {
            freq[cost]++;
        }

        // 通过一个每个冰淇凌的价格频率，然后从低到高来统计可以买冰淇淋的最大数量
        // 从前面获得的最低的冰淇淋单价开始遍历
        // 对于不存在的单价冰淇淋会做无效的过滤计算
        for(x = i = res, res = 0; i <= coins; x = ++i) {
            // 获得当前价格冰淇淋单价乘以数量的价格
            // 如果当前的单价并不存在冰淇凌价格数组中，会进行一个0消耗计算
            x *= n = freq[i];
            // 判断当前价格冰淇淋的总价是否大于总的资金
            if(x > coins) {
                // 直接返回已买的数量加以剩下资金可以购买当前单价冰淇淋的数量
                return res += coins/i;
            }
            // 如果当前单价的冰淇淋的总价小于现有的资金
            // 将当前单价可以购买的数量添加到总购买量中
            res += n;
            // 资金量检出此次购买的消耗量
            coins -= x;
            // 进行下一个单价冰淇淋的判断
        }

        return res;
    }
    
    /**
     * @description: 使用HashMap来存储每个单价对应的数量，效率变慢
     * @param: [int[], int] [costs, coins] 
     * @return: int
     * @author YORICHEONG
     * @date: 2021/7/2 11:28
     */
    public int maxIceCream02(int[] costs, int coins) {
        // 冰淇淋价格数组的长度
        int n = costs.length;
        int i = 0;
        int x = 0;
        int res = 100000;
        long d = 0;

        // 获得冰淇淋价格数组中的最大值和最小值
        for(; i < n; i++) {
            d += costs[i];
            if (costs[i] > x) {
                // 最大值
                x = costs[i];
            }
            if (costs[i] < res) {
                // 最小值
                res = costs[i];
            }
        }

        // 如果已有的资金大于所有的冰淇淋的价格之合，那么直接返回整个冰淇淋数组的长度
        if(coins >= d){
            return n;
        }

        // 如果最贵的冰淇淋价格和最便宜的冰淇淋价格一样，那么直接返回已有的资金除以冰淇淋的单价
        if(x == res) {
            return coins/x;
        }

        Map<Integer,Integer> countMap = new HashMap<>();
        for(int cost : costs){
            if(countMap.containsKey(cost)) {
                countMap.put(cost,countMap.get(cost)+1);
            } else {
                countMap.put(cost, 1);
            }
        }
        System.out.println(countMap.toString());
        // 通过一个每个冰淇凌的价格频率，然后从低到高来统计可以买冰淇淋的最大数量
        // 从前面获得的最低的冰淇淋单价开始遍历
        // 对于不存在的单价冰淇淋会做无效的过滤计算
        for(x = i = res, res = 0; i <= coins ; x = ++i) {
            if(!countMap.containsKey(i)){
                continue;
            }
            int count = countMap.get(i);
            // 获得当前价格冰淇淋单价乘以数量的价格
            // 如果当前的单价并不存在冰淇凌价格数组中，会进行一个0消耗计算
            x *= n = count;
            // 判断当前价格冰淇淋的总价是否大于总的资金
            if(x > coins) {
                // 直接返回已买的数量加以剩下资金可以购买当前单价冰淇淋的数量
                return res += coins/i;
            }
            // 如果当前单价的冰淇淋的总价小于现有的资金
            // 将当前单价可以购买的数量添加到总购买量中
            res += n;
            // 资金量检出此次购买的消耗量
            coins -= x;
            // 进行下一个单价冰淇淋的判断
        }

        return res;
    }

    public static void main(String[] args) {
        int[] test = new int[]{7,3,3,6,6,6,10,5,9,2};
        int coinst = 56;
        new maxIceCream_20210702().maxIceCream02(test,coinst);
    }
}
