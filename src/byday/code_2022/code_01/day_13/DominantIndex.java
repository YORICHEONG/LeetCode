package byday.code_2022.code_01.day_13;

/**
 * @Description 测试结果
 * @Author YORICHEONG yoricheong@gmail.com precent99@qq.com
 * @Date 2022/1/13 10:00
 * @Tags
 **/
public class DominantIndex {
    /**
     * @Description:
     * @Author: YORICHEONG 
     * @Date: 10:01 2022/1/13
     **/
    public int dominantIndex(int[] nums) {
        if(nums.length == 1) {
            return 0;
        }
        int max = nums[0];
        int secondMax = Integer.MIN_VALUE;
        int maxIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] > max) {
                secondMax = max;
                max = nums[i];
                maxIndex = i;
            } else {
                if(nums[i] > secondMax) {
                    secondMax = nums[i];
                }
            }
        }
        if(max >= secondMax * 2) {
            return maxIndex;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] testArray = {3,6,1,0};
        new DominantIndex().dominantIndex(testArray);
    }
}
/**
 * 给你一个整数数组 nums ，其中总是存在 唯一的 一个最大整数 。
 *
 * 请你找出数组中的最大元素并检查它是否 至少是数组中每个其他数字的两倍 。
 *
 * 如果是，则返回 最大元素的下标 ，否则返回 -1 。
 *
 */