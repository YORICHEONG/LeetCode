package byday.code_2021_11_01;

import java.util.Arrays;

/**
 * @Description 给定一个整数数组 A，我们只能用以下方法修改该数组：我们选择某个索引 i 并将 A[i] 替换为 -A[i]，然后总共重复这个过程 K 次。
 * （我们可以多次选择同一个索引 i。）
 * 以这种方式修改数组后，返回数组可能的最大和。
 * @Author YORICHEONG yoricheong@gmail.com precent99@qq.com
 * @Date 2021/11/1 10:30
 * @Tags
 **/
public class LargestSumAfterKNegations {

    public static void main(String[] args) {
        System.out.println(new LargestSumAfterKNegations().largestSumAfterKNegations(new int[]{-8,3,-5,-3,-5,-2,
        6}, 6));
        // -8, -5, -5, -3, -2,
    }

    /**
     * @Description: 将这个数组来进行排序，然后从负数到正数来进行排序
     * @Author: YORICHEONG 
     * @Date: 10:45 2021/11/1
     **/
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int preValue = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length && k > 0; i++) {
            if(nums[i] < 0) {
                nums[i] = -nums[i];
                k--;
                preValue = nums[i];
                continue;
            }
            if(nums[i] == 0) {
                k = 0;
                break;
            }
            if(nums[i] > 0 && k % 2 != 0) {
                if(nums[i] > preValue) {
                    nums[i-1] = -preValue;
                    nums[i] = nums[i];
                    k = 0;
                    break;
                } else {
                    nums[i] = -nums[i];
                    k = 0;
                    break;
                }
            }
            if(nums[i] > 0 && k % 2 == 0) {
                nums[i] = nums[i];
                k = 0;
                break;
            }
        }
        Arrays.sort(nums);
        if(k > 0) {
            if(k % 2 == 0) {
                nums[0] = nums[0];
            } else {
                nums[0] = -nums[0];
            }
        }

        return sumArray(nums);
    }

    private int sumArray(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }

        return sum;
    }
}
