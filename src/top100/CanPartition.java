package top100;

import com.sun.xml.internal.txw2.output.DumpSerializer;

import java.util.Arrays;

/**
 * @Description 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * @Author YORICHEONG yoricheong@gmail.com precent99@qq.com
 * @Date 2021/10/21 10:36
 * @Tags
 * @Exemple
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
 *
 **/
public class CanPartition {
    private int cnt = 0;

    /**
     * @Description:
     * @Author: YORICHEONG 
     * @Date: 10:36 2021/10/21
     **/
    public boolean canPartition(int[] nums) {

        return false;
    }

    // Office Method=================================
    class solution {
        class Solution {
            public boolean canPartition(int[] nums) {
                int n = nums.length;
                if (n < 2) {
                    return false;
                }
                int sum = 0, maxNum = 0;
                for (int num : nums) {
                    sum += num;
                    maxNum = Math.max(maxNum, num);
                }
                if (sum % 2 != 0) {
                    return false;
                }
                int target = sum / 2;
                if (maxNum > target) {
                    return false;
                }
                boolean[][] dp = new boolean[n][target + 1];
                for (int i = 0; i < n; i++) {
                    dp[i][0] = true;
                }
                dp[0][nums[0]] = true;
                for (int i = 1; i < n; i++) {
                    int num = nums[i];
                    for (int j = 1; j <= target; j++) {
                        if (j >= num) {
                            dp[i][j] = dp[i - 1][j] | dp[i - 1][j - num];
                        } else {
                            dp[i][j] = dp[i - 1][j];
                        }
                    }
                }
                return dp[n - 1][target];
            }
        }
    }
}
