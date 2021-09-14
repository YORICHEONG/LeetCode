package top100;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @description: 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * @author YORICHEONG
 * @date 2021/9/13 9:44
 * @version 1.0
 */
public class FindKthLargest {

    /**
     * @param: nums
     * @param: k
     * @description : 直接使用简单的解决方法
     * @return : int
     * @author : YORICHEONG
     * @date : 2021/9/13
     */
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
