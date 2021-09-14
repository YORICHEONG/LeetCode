package top100;

import com.sun.org.apache.bcel.internal.generic.ARETURN;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，
 * 其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 * @author YORICHEONG
 * @date 2021/9/13 10:04
 * @version 1.0
 */
public class ProductExceptSelf {

    /**
     * @param: nums
     * @description : 使用先求出第一个位置的值，然后再来遍历求出其他位置的值
     * @return : int[]
     * @author : YORICHEONG
     * @date : 2021/9/13
     */
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int firstSum = getExceptSum(nums, 0);
        result[0] = firstSum;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] == 0) {
                result[i] = getExceptSum(nums, i);
            } else {
                result[i] = firstSum / nums[i] * nums[0];
            }
        }
        return result;
    }
    
    /**
     * @param: nums
     * @param: i
     * @description : 调用这个方法专门用来获得一个数组中的其他位置的数的总和
     * @return : int
     * @author : YORICHEONG
     * @date : 2021/9/13
     */
    private int getExceptSum(int[] nums, int i) {
        int sum = 1;
        for (int j = 0; j < nums.length; j++) {
            if(j != i) {
                sum *= nums[j];
            }
        }
        return sum;
    }


    //==========================使用动态的规划的来进行解决问题=====================================
    
    /**
     * @param: nums
     * @description : 使用左右的数组的形式来计算数组中的值
     * @return : int[]
     * @author : YORICHEONG
     * @date : 2021/9/13
     */
    public int[] productExceptSelf2(int[] nums) {
        int length = nums.length;
        // 首先创建一个左数组用来存储这个左边的值
        int[] left = new int[length];
        // 创建一个右数组来存储右边值
        int[] right = new int[length];
        int[] answer = new int[length];

        // 首先遍历获取左数组中的值
        left[0] = 1;
        for (int i = 1; i < length; i++) {
            // 动态的获取当前数组组成的左边的值
            left[i] = nums[i - 1] * left[i - 1];
        }

        right[length-1] = 1;
        for (int i = length - 2; i >= 0; i--) {
            right[i] = nums[i + 1] * right[i + 1];
        }

        for (int i = 0; i < length; i++) {
            answer[i] = right[i] * left[i];
        }

        return answer;
    }
}
