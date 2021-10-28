package byday.code_2021_10_28;

/**
 * @Description 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * @Author YORICHEONG
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2021-10-28
 */
public class MaxSubArray {
    /**
     * 动态规划的问题要有一个状态的表示，这里面的重点是如何来进行妆台的转换
     * 重点是这个状态的转移方程 f(i)=max{f(i−1)+nums[i],nums[i]}】
     * 假如这个状态的转移方程表示的这个位置，最大的连续的值
     * 那么然后就可以求出整个方程的表示
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        // 如果想要更加的直接点化，可以直接创建一个f数组来进行存储状态
        int[] f = new int[nums.length];
        f[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 如何获得一个状态的转移方程是一个很重要的点
            int res = Math.max(nums[i], f[i - 1] + nums[i]);
            f[i] = res;
            sum = Math.max(sum, res);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] test = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new MaxSubArray().maxSubArray(test));
    }
}
