package top100;

/**
 * @description: 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，
 * 使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
 * 例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 * @author YORICHEONG
 * @date 2021/8/26 15:09
 * @version 1.0
 */
public class RoteArraySearch {
    /**
     * @param: nums
     * @param: target
     * @description : 100%AC Method
     * @return : int
     * @author : YORICHEONG
     * @date : 2021/8/26
     */
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return -1;
        }

        if(target >= nums[0]) {
            for (int i = 0, j = i+1; i < nums.length; i++, j++) {
                if(nums[i] == target) {
                    return i;
                }
                if(j < nums.length && nums[j] < nums[i]) {
                    return -1;
                }
            }
        } else if(target <= nums[nums.length-1]) {
            for (int i = nums.length - 1, j = i-1; i >= 0; i--,j--) {
                if(nums[i] == target) {
                    return i;
                }
                if(j >= 0 && nums[i] < nums[j]) {
                    return -1;
                }
            }
        }
        return -1;
    }
}
