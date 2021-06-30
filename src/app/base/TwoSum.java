
package app.base;
import java.util.HashMap;



/**
 * 
  给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。

你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。

你可以按任意顺序返回答案。

输入：nums = [2,7,11,15], target = 9
输出：[0,1]
解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。

输入：nums = [3,2,4], target = 6
输出：[1,2]

输入：nums = [3,3], target = 6
输出：[0,1]
**/

public class TwoSum {
    /**
     * 使用HashMap的方式来解决问题
     */
    public int[] twoSum_01(int[] nums, int target) {
        HashMap<Integer,Integer> hashMap = new HashMap<Integer,Integer>();
        for(int i = 0; i<nums.length; i++){
            if(hashMap.get((target-nums[i]))!=null){
                return new int[]{hashMap.get((target-nums[i])),i};
            }
            hashMap.put(nums[i],i);
        }
        return new int[]{0,0};
    }
    /**
     * 使用双指针来进行遍历的查找
     */
    public int[] twoSum_2(int[] nums,int target){
        int j = 1;
        int i = 0;
        int maxLength = nums.length-1;
        while(nums[i]+nums[j]!=target){
            if(j == maxLength){
                i++;
                j = i;
            }
            j++;
        }
        return new int[]{i,j};
    }
}
