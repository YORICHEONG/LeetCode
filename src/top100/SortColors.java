package top100;

/**
 * @description: 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，
 * 使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * @author YORICHEONG
 * @date 2021/9/8 16:12
 * @version 1.0
 */
public class SortColors {
    /**
     * @param: nums
     * @description : 用这个方法来进行颜色排序
     * @return : void
     * @author : YORICHEONG
     * @date : 2021/9/8
     */
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                left ++;
            }
            if(nums[i] == 2) {
                right--;
            }
        }
        for (int i = 0; i < left; i++) {
            nums[i] = 0;
        }
        for (int i = left; i <= right ; i++) {
            nums[i] = 1;
        }
        for (int i = right+1; i < nums.length ; i++) {
            nums[i] = 2;
        }
    }
}
