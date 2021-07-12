package dailypunch;/**
 * @Description
 * @author YORICHEONG
 * @create 2021-07-07 9:34
 */

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 大餐 是指 恰好包含两道不同餐品 的一餐，其美味程度之和等于 2 的幂。
 *
 * 你可以搭配 任意 两道餐品做一顿大餐。
 *
 * 给你一个整数数组 deliciousness ，其中 deliciousness[i] 是第 i​​​​​​​​​​​​​​ 道餐品的美味程度，返回你可以用数组中的餐品做出的不同 大餐 的数量。结果需要对 109 + 7 取余。
 *
 * 注意，只要餐品下标不同，就可以认为是不同的餐品，即便它们的美味程度相同。
 *
 *
 * 示例 1：
 *
 * 输入：deliciousness = [1,3,5,7,9]
 * 输出：4
 * 解释：大餐的美味程度组合为 (1,3) 、(1,7) 、(3,5) 和 (7,9) 。
 * 它们各自的美味程度之和分别为 4 、8 、8 和 16 ，都是 2 的幂。
 *
 * 示例 2：
 *
 * 输入：deliciousness = [1,1,1,3,3,3,7]
 * 输出：15
 * 解释：大餐的美味程度组合为 3 种 (1,1) ，9 种 (1,3) ，和 3 种 (1,7) 。
 *
 * 
 * @author YORICHEONG
 * @date 2021/7/7 9:34
 * @version 1.0
 */
public class CountPairs_20210707 {
    
    /**
     * @description: 排行第一题解
     * @param: [int[]] [deliciousness] 
     * @return: int
     * @author YORICHEONG
     * @date: 2021/7/7 10:08
     */
    public int countPairs02(int[] deliciousness) {
        int min,max;
        min = max = deliciousness[0];
        for(int v : deliciousness) {
            if (v < min) {
                min = v;
            } else if (v > max) {
                max = v;
            }
        }

        int[] map = new int[max-min+1];
        long res = 0;
        for(int v: deliciousness) {
            for(int s = 1;; s <<= 1) {
                int x = s - v;
                if(x < min) {
                    continue;
                }
                if(x > max) {
                    break;
                }
                res += map[x-min];
            }
            map[v-min]++;
        }
        return (int)(res%1000000007L);
    }


    /**
     * @description: 官方题解
     * @param: [int[]] [deliciousness] 
     * @return: int
     * @author YORICHEONG
     * @date: 2021/7/7 9:54
     */
    public int countPairs(int[] deliciousness) {
        final int MOD = 1000000007;
        int maxValue = 0;
        // 找到最大值
        for(int val : deliciousness) {
            maxValue = Math.max(val,maxValue);
        }
        int maxSum = maxValue*2;
        int count = 0;
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        int n = deliciousness.length;
        for (int i = 0; i < n; i++) {
            int val = deliciousness[i];
            for (int sum = 1; sum <= maxSum; sum <<= 1) {
                int currentCount = map.getOrDefault(sum-val,0);
                count = (currentCount+count) % MOD;
            }
            map.put(val,map.getOrDefault(val,0)+1);
        }
        return count;
    }

    // 直接进行遍历的方法超时
    /**
     * @description:
     * @param: [int[]] [deliciousness] 
     * @return: int
     * @author YORICHEONG
     * @date: 2021/7/7 9:35
     */
    /*
    public int countPairs(int[] deliciousness) {
        int count = 0;
        for(int i = 0; i < deliciousness.length; i++) {
            for(int j = i+1; j < deliciousness.length; j++) {
                if(isDelicious(deliciousness[i],deliciousness[j])) {
                    count++;
                }
            }
        }
        return count;
    }
    */
    /**
     * @description:
     * @param: [int, int] [i, j] 
     * @return: boolean
     * @author YORICHEONG
     * @date: 2021/7/7 9:37
     */
    /*
    private boolean isDelicious(int i, int j) {
        int result = i+j;
        return (result & (result-1)) == 0;
    }*/
}
