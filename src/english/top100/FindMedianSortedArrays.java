package english.top100;

/**
* @Description
* @author YORICHEONG
* @create 2021-07-02 18:29
*/

import java.util.Arrays;

/**
 * @description: Given two sorted arrays nums1 and nums2 of size m and n
 *               respectively, return the median of the two sorted arrays. The
 *               overall run time complexity should be O(log (m+n)).
 *
 *               Input: nums1 = [1,3], nums2 = [2] Output: 2.00000 Explanation:
 *               merged array = [1,2,3] and median is 2.
 *
 *               Input: nums1 = [], nums2 = [1] Output: 1.00000
 *
 *               Example 5: Input: nums1 = [2], nums2 = [] Output: 2.00000
 *
 *
 * @author YORICHEONG
 * @date 2021/7/2 18:29
 * @version 1.0
 */
public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 1) {
            return nums2[0];
        }
        if (nums2.length == 0 && nums1.length == 1) {
            return nums1[0];
        }
        if (nums1.length == 0 && nums2.length == 0) {
            return 0;
        }

        int m = nums1.length;
        int n = nums2.length;
        boolean isEven = (m + n) % 2 == 0;

        if (m > n) {
            return findMedian(nums1, nums2);
        } else {
            return findMedian(nums2, nums1);
        }
    }

    private double findMedian(int[] longArray, int[] shortArray) {
        int l = longArray.length;
        int s = shortArray.length;

        int iMin = 0;
        int iMax = l;

        double leftMax;
        double rightMin;

        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = (l + s) / 2 - i;

            if (i < l && longArray[j - 1] > shortArray[i]) {

            }
        }
        return 0;
    }
}
