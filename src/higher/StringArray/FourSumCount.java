package higher.StringArray;
/**
 * @author YORICHEONG
 * @date 2021-06-29 17:06:29
 * @description Given four integer arrays nums1, nums2, nums3, and nums4 all of length n, return the number of tuples (i, j, k, l) such that
 * 0 <= i, j, k, l < n
 * nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 */
import java.util.Map;
import java.util.HashMap;
public class FourSumCount {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();

        for(int A : nums1) {
            for(int B : nums2) {
                map.put(A+B, map.getOrDefault(A+B, 0)+1);
            }
        }
        int ans = 0;
        for(int C : nums3) {
            for(int D : nums4) {
                if(map.containsKey(-C-D)) {
                    ans += map.get(-C-D);
                }
            }
        }
        return ans;
    }
}
