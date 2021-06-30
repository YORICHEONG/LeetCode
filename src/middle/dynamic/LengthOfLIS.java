package middle.dynamic;

import java.util.Arrays;

/**
 * 2021-06-24 10:28:20
 * author：YORICHEONG
 */
public class LengthOfLIS {
    /**
     * 使用动态规划的方法
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        // 然后创建一个数组来记录当前位置的最长递增序列个数
        int[] dp = new int[nums.length];
        int res = 0;
        Arrays.fill(dp, 1);
        // 进行遍历，查找最大的值
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    // 然后来进行更新
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            // 实时更新最长的子序列个数
            res = Math.max(res, dp[i]);
        }
        // 最后的就是当前位置的最长的递增子序列
        return res;

    }

    
}
