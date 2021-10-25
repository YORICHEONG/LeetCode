package top100;

/**
 * @Description 给你一个整数数组 nums 和一个整数 k ，请你统计并返回该数组中和为 k 的连续子数组的个数。
 * @Author YORICHEONG yoricheong@gmail.com precent99@qq.com
 * @Date 2021/10/25 9:42
 * @Tags
 **/
public class SubarraySum {
    /**
     * @Description: 使用暴力的搜索方法来进行搜索
     * @Author: YORICHEONG 
     * @Date: 9:42 2021/10/25
     **/
    public int subarraySum(int[] nums, int k) {
        int length = nums.length;
        int count = 0;

        for (int i = 0; i < length; i++) {
            int sum = 0;
            for (int j = i; j < length; j++) {
                sum += nums[j];
                if(sum == k) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(new SubarraySum().subarraySum(new int[]{1,2,3}, 3));
    }
}
