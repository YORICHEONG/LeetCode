package middle.SortSearch;

import java.rmi.ConnectIOException;

/**
 * 2021年6月23日16:45:49
 * autor：YORICHEONG
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。

在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。

给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。

    输入：nums = [4,5,6,7,0,1,2], target = 0
    输出：4

    输入：nums = [4,5,6,7,0,1,2], target = 3
    输出：-1
 */
public class Search {

    public int search(int[] nums, int target) {
       
        //当长度为1的时候
        if(nums.length==1) {
            return target == nums[0]? 0:-1;
        }
         //通过一个标识来进行判断
        boolean flag = target>nums[nums.length-1];
        if(flag) {
            for(int i = 0; i < nums.length-1; i++) {
                if(target != nums[i] && target != nums[i+1] && nums[i] > nums[i+1]){
                    return -1;
                }else if(target == nums[i] || target == nums[i+1]) {
                    return target == nums[i]? i:i+1;
                }else{
                    continue;
                }
            }
            //数据在前段
        }else {
            for(int i = nums.length-1; i > 0; i--){
                if(target != nums[i] && target != nums[i-1] && nums[i] < nums[i-1]) {
                    return -1;
                }else if(target == nums[i] || target == nums[i-1]) {
                    return target == nums[i]? i:i-1;
                }else {
                    continue;
                }
            }
        }
        return -1;
    }

    /**
     * 方法二，
     * 通过招到扭转点，然后分段进行二分查找
     */
    private void solution(){

    }
    
    /**
     * 招到扭转点，然后将数据进行还原，然后再整个有序的数组进行二分查找
     */
    private void solution2(){

    }
}
