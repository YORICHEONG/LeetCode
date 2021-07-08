package dailypunch;
/**
 * @author YORICHEONG
 * @data 2021-07-08 10:18:05
 * @descrption 
 */
public class numSubarraysWithSum_20210708 {
    /**
     * 使用滑动窗口来遍历查找符合的子数组
     * @param nums
     * @param goal
     * @return
     */
    public int numSubarraysWithSum(int[] nums, int goal) {
        int numsLength = nums.length;
        int windowLeft1 = 0;
        int windowLeft2 = 0;
        int windowRight = 0;
        int windowSum1 = 0;
        int windowSum2 = 0;
        
        int resultCount = 0;
        while(windowRight < numsLength) {
            windowSum1 += nums[windowRight];
            while( windowLeft1 <= windowRight && windowSum1 > goal) {
                windowSum1 -= nums[windowLeft1];
                windowLeft1++;
            }
            windowSum2 += nums[windowRight];
            while(windowLeft2 <= windowRight && windowSum2 >= goal) {
                windowSum2 -= nums[windowLeft2];
                windowLeft2++;
            }

            resultCount += windowLeft2-windowLeft1;
            windowRight++;
        }
        return resultCount;
    }
}
