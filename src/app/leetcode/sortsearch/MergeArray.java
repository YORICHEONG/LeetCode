package app.leetcode.sortsearch;
/**
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。

初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。


 */
public class MergeArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] result = new int[m+n];
    	int index = 0;
    	int i = 0;
    	int j = 0;
    	while(i<m&&j<n){
    		if(nums1[i]>nums2[j]){
    			result[index++] = nums2[j++];
    		}else{
    			result[index++] = nums1[i++];
    		}
    	}
    	for(;i<m;){
    		result[index++] = nums1[i++];
    	}
    	for(;j<n;){
    		result[index++] = nums2[j++];
    	}
    	for(int k = 0; k<m+n; k++){
    		nums1[k] = result[k];
    	}
    }
}
