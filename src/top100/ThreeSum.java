package top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 三数之和
 * @author YORICHEONG
 * @date 2021/8/18 9:34
 * @version 1.0
 */
public class ThreeSum {
    /**
     * @param: nums
     * @description : 三数之和
     * @return : java.util.List<java.util.List<java.lang.Integer>>
     * @author : YORICHEONG
     * @date : 2021/8/18
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        if(nums == null || len < 3) {
            return ans;
        }
        // 对Arrays进行排序
        Arrays.sort(nums);

        for (int i = 0; i < len; i++) {
            // 如果当前下标的数字大于零，那么三个数之和一定大于零
            if(nums[i]>0) {
                break;
            }
            // 去除重复的数字
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int left = i+1;
            int right = len - 1;
            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while(left < right && nums[left] == nums[left+1]) {
                        left++;
                    }
                    while(left < right && nums[right] == nums[right-1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if(sum < 0) {
                    left++;
                } else if(sum > 0) {
                    right--;
                }
            }
        }
        return ans;
    }
}
