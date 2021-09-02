package top100;
/**
 * @description: 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。[3,2,1,0,4]
 * @author YORICHEONG
 * @date 2021/9/1 17:24
 * @version 1.0
 */
public class CanJump {
    /**
     * @param: nums
     * @description : 动态维护的算法
     * @return : boolean
     * @author : YORICHEONG
     * @date : 2021/9/1
     */
    public boolean canJump(int[] nums) {
        //　最大能到达的距离
        int maxArriveIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if(i > maxArriveIndex) {
                return false;
            }
            // 动态的更新最大的能到达的距离
            maxArriveIndex = Math.max(maxArriveIndex, i + nums[i]);
        }
        return true;
    }


    //==============Method 2======================================//

    /**
     * @param: nums
     * @description : 一样的动态方法
     * @return : boolean
     * @author : YORICHEONG
     * @date : 2021/9/1
     */
    public boolean canJump2(int[] nums) {
        int length = nums.length;
        int rightMaxArrive = 0;
        for (int i = 0; i < length; i++) {
            if(i <= rightMaxArrive) {
                rightMaxArrive = Math.max(rightMaxArrive, nums[i] + i);
                if(rightMaxArrive >= length - 1) {
                    return true;
                }
            }

        }
        return false;
    }

    //==============Method 3===[3,2,1,0,4]================//
    
    /**
     * @param: nums
     * @description : 最快的方法
     * @return : boolean
     * @author : YORICHEONG
     * @date : 2021/9/1
     */
    public boolean canJump3(int[] nums) {
        int end = nums.length-1;
        for (int i = nums.length-2; i >= 0 ; i--) {
            if(nums[i] + i > end) {
                end = i;
            }
        }
        if(end == 0) {
            return true;
        }
        return false;
    }
}
