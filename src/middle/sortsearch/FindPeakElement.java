package middle.sortsearch;
/**
 * 2021-06-23 10:21:29
 * author:YORICHEONG
 */
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int i = 0;
        int j = nums.length-1;
        if(nums.length==1){
            return 0;
        }
        while(i < j) {
            if(nums[i] <= nums[i+1] && i <= j) {
                // 递增的情况
                i++;
            }else if(nums[i] > nums[i+1] && i<= j){
                // 遇到转折点的情况
                return i;
            }else {
                //递减的情况
                while(i <= j && nums[i] > nums[i+1]) {
                    i++;
                }
            }
        }
        return i;
    }

}
