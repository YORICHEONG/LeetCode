package middle.SortSearch;

/**
 * 2021年6月23日10:42:58
 * author:YORICHEONG
 */
public class SearchRang {
    public int[] searchRange(int[] nums, int target) {
        // 使用二分查找来实现范围的查找
        int index = middleSearch(nums, target);
        if(index == -1){
            return new int[]{-1,-1};
        }
        int i = index-1,j = index+1;
        while(i >= 0 && nums[i] == target){
            i--;
        }
        while(j <= nums.length-1 && nums[j] == target){
            j++;
        }
        int[] result = new int[]{i+1,j-1};
        return result;
    }
    /**
     * 
     * @param a
     * @param target
     * @return
     */
    private int middleSearch(int[] a, int target){
        int left = 0;
        int right = a.length-1;
        while(left <= right) {
            int middle = left+((right-left)/2);
            if(a[middle] == target) {
                return middle;
            }else if(a[middle] < target) {
                left = middle+1;
            }else{
                right = middle-1;
            }
        }
        return -1;
    }
}
