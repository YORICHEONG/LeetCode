package byday.code_2021_11_01;

import java.util.Arrays;

/**
 * @Description 给定由一些正数（代表长度）组成的数组 A，返回由其中三个长度组成的、面积不为零的三角形的最大周长。
 * 如果不能形成任何面积不为零的三角形，返回 0。
 * @Author YORICHEONG yoricheong@gmail.com precent99@qq.com
 * @Date 2021/11/1 10:15
 * @Tags
 **/
public class LargestPerimeter {
    /**
     * @Description: 如果没有给定有序的数组，我们可以先将这个数组来进行排序，然后数组中从大到小来进行判断
     * @Author: YORICHEONG 
     * @Date: 10:15 2021/11/1
     **/
    public int largestPerimeter(int[] nums) {
        if(nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        // 然后进行从后到前来进行遍历排序
        for (int i = nums.length - 1; i >= 2 ; i--) {
            // 判断符合条件的最大的三条边
            if(nums[i] < nums[i - 1] + nums[i - 2]) {
                return nums[i] + nums[i - 1] + nums[i - 2];
            }
        }
        return 0;
    }
}
