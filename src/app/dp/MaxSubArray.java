package app.dp;
/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int min = nums[0];
        int max = min;
        for(int i = 1; i<nums.length; i++){
            min = Math.max(0, min)+nums[i];//如果新的数小于0，就使用当前的数为起点
            max = Math.max(min, max);//比较最大的数和当前的数的大小
        }
        return max;
    }
}
