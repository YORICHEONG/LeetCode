package english.dailypunch;

/**
 * @author YORICHEONG
 * @date 2021-07-09 11:29:45
 * @description Given two integer arrays nums1 and nums2, return the maximum length of a subarray that appears in both arrays.
 */
public class findLength_20210709 {
    /**
     * use DP method
     * @param nums1
     * @param nums2
     * @return
     */
    public int findLength(int[] nums1, int[] nums2) {
        int nums1Length = nums1.length;
        int nums2Length = nums2.length;
        int result = 0;
        int[][] dp = new int[nums1Length+1][nums2Length+1];
        for (int i = 1; i <= nums1Length; i++) {
            for (int j = 1; j <= nums2Length; j++) {
                dp[i][j] = nums1[i-1] == nums2[j-1] ? dp[i-1][j-1]+1 : 0;
                result = Math.max(result, dp[i][j]);
            }
        } 
        return result;
    } 
}
