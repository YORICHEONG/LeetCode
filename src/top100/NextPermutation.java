package top100;

/**
 * @description: 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列（即，组合出下一个更大的整数）。
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * 必须 原地 修改，只允许使用额外常数空间。
 * @author YORICHEONG
 * @date 2021/8/26 14:07
 * @version 1.0
 */
public class NextPermutation {
    //==============Method 1==================================================================//

    /**
     * @param: nums
     * @description :
     * @return : void
     * @author : YORICHEONG
     * @date : 2021/8/26
     */
    public void nextPermutation(int[] nums) {
        if(nums.length < 1) {
            return;
        }

        int i = nums.length - 2;
        int j = nums.length - 1;
        int k = nums.length - 1;

        while(i >= 0 && nums[i] >= nums[j]) {
            i--;
            j--;
        }

        if(i >= 0) {
            while(nums[i] >= nums[k]) {
                k--;
            }
            // swap
            swap(nums, i, k);
        }

        // reverse
        for (int l = j, x = nums.length - 1; l < x; l++, x--) {
            swap(nums, l, x);
        }
    }

    /**
     * @param: nums
     * @param: left
     * @param: right
     * @description : 数组中两个元素进行交换
     * @return : void
     * @author : YORICHEONG
     * @date : 2021/8/26
     */
    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

}
