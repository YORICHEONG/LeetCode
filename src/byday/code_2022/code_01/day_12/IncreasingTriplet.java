package byday.code_2022.code_01.day_12;

/**
 * @Description
 * @Author YORICHEONG yoricheong@gmail.com precent99@qq.com
 * @Date 2022/1/12 10:12
 * @Tags
 **/
public class IncreasingTriplet {
    public boolean increasingTriplet(int[] nums) {
        if(nums.length < 3) {
            return false;
        }
        boolean isSecond = false;
        boolean isThird = false;
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            while(nums[j] <= nums[i] && j < nums.length) {
                j++;
            }

            int x = j + 1;
            while(nums[x] <= nums[j] && x < nums.length) {
                x++;
            }

        }

        return false;
    }
    // 双向遍历的方法
    class Solution1{

        public boolean increasingTriplet(int[] nums) {
            int numLength = nums.length;
            if(numLength < 3) {
                return false;
            }
            int[] leftMin = new int[numLength];
            int[] rightMax = new int[numLength];

            // 首先来初始化leftMin数组
            leftMin[0] = nums[0];
            for (int i = 1; i < numLength; i++) {
                leftMin[i] = Math.min(leftMin[i - 1], nums[i]);
            }

            // 初始化rightMax数组
            rightMax[numLength - 1] = nums[numLength - 1];
            for (int i = numLength - 2; i >= 0 ; i--) {
                rightMax[i] = Math.max(rightMax[i + 1], nums[i]);
            }

            // 然后对原来的数组进行一次遍历
            for (int i = 1; i < numLength; i++) {
                if(nums[i] > leftMin[i - 1] && nums[i] < rightMax[i + 1]) {
                    return true;
                }
            }

            return false;
        }
    }
    // 使用贪心算法
    class Solution2 {
        public boolean increasingTriplet(int[] nums) {
            int numLength = nums.length;
            if(numLength < 3) {
                return false;
            }

            int first = nums[0];
            int second = Integer.MAX_VALUE;

            for (int i = 1; i < nums.length; i++) {
                // 遍历每一个数字
                int num = nums[i];
                // 如果当前的数字大于第二个字符，就表示有三个连续的数字
                if(num > second) {
                    return true;
                } else if(num > first) { // 如果当前数字大于第一个数字，就将数字进行替换，将当前的数字替换成为第二个数字
                    second = num;
                } else {
                    // 如果这个数字没有任何的功能，就将这个数字设置成为第一个数字
                    first = num;
                }
            }
            return false;
        }
    }
}
/**
 * 给你一个整数数组nums ，判断这个数组中是否存在长度为 3 的递增子序列。
 *
 * 如果存在这样的三元组下标 (i, j, k)且满足 i < j < k ，使得nums[i] < nums[j] < nums[k] ，返回 true ；
 *
 * 否则，返回 false 。
 */