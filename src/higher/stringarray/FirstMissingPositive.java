package higher.stringarray;/**
 * @Description
 * @author YORICHEONG
 * @create 2021-06-30 11:12
 */

/**
 * @description: 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案
 * @author YORICHEONG
 * @date 2021/6/30 11:12
 * @version 1.0
 */
public class FirstMissingPositive {

    /**
     * @description:
     * @param: [int[]] [nums] 
     * @return: int
     * @author YORICHEONG
     * @date: 2021/6/30 11:20
     */
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        for(int i = 0; i < n; i++) {
            if(nums[i] <= 0) {
                nums[i] = n+1;
            }
        }

        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if(num <= n) {
                // 然后将符合条件的值的位置设置为负数
                nums[num - 1] = -Math.abs(nums[num-1]);
            }
        }

        for (int i = 0; i < n; i++) {
            if(nums[i] > 0) {
                return i+1;
            }
        }

        return n+1;
    }
}
