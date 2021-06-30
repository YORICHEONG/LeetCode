package app.leetcode.base;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 
 * 输入: [0,1,0,3,12]
   输出: [1,3,12,0,0]


    必须在原数组上操作，不能拷贝额外的数组。
    尽量减少操作次数。
 */
public class MoveZeroArray {
    /**
     * 把非零的往前移动,然后将后面的直接全部设置位0
     * @param nums
     */
    public void moveZeroes_1(int[] nums) {
        if(nums==null||nums.length==0){
            return;
        }
        int index = 0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i] != 0){
                nums[index++] = nums[i];
            }
        }
        while(index<nums.length){
            nums[index++] = 0;
        }
    }
    /**
     * 使用两个指针来进行一个遍历，然后替换
     * @param nums
     */
    public void moveZeroes_2(int[] nums){
        int i = 0;
        for(int j = 0; j<nums.length; j++){
            if(nums[j]!=0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }
    }

}
