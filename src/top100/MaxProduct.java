package top100;

/**
 * @description: TODO
 * @author YORICHEONG
 * @date 2021/7/30 10:38
 * @version 1.0
 */
public class MaxProduct {
    /**
     * @param: nums
     * @description : TODD
     * @return : int
     * @author : YORICHEONG
     * @date : 2021/7/30
     */
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int ans = nums[0];

        int length = nums.length;

        for (int i = 1; i < length; i++) {
            int mx = max;
            int mn = min;
            max = Math.max(mx * nums[i], Math.max(nums[i], mn * nums[i]));
            min = Math.min(mn * nums[i], Math.min(nums[i], mx * nums[i]));
            ans = Math.max(max, ans);
        }
        return ans;
    }
}
