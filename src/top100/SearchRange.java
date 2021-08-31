package top100;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

/**
 * @description: 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * 进阶：
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 * @author YORICHEONG
 * @date 2021/8/26 15:27
 * @version 1.0
 */
public class SearchRange {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for(String s : list) {
            System.out.println(s);
        }
    }


    /**
     * @param: nums
     * @param: target
     * @description : 服了
     * @return : int[]
     * @author : YORICHEONG
     * @date : 2021/8/27
     */
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return new int[]{-1,-1};
        }
        int i = 0;
        int j = nums.length - 1;
        int[] ans = new int[]{-1,-1};
        boolean isContinueI = true;
        boolean isContinueJ = true;
        boolean isLast = false;
        int x = 0;
        while(i <= j) {
            int mid = (i + j) / 2;
            if( x == 1) {
                isLast = true;
            }
            if(nums[mid] > target) {
                if(isLast) {
                    break;
                }
                j = mid - 1;
                if( i == j) {
                    x = 1;
                    continue;
                }
            } else if(nums[mid] < target) {
                if(isLast) {
                    break;
                }
                i = mid + 1;
                if( i == j) {
                    x = 1;
                    continue;
                }
            } else {
                for (int k = mid; k <= nums.length; k++) {
                    if(k == nums.length || nums[k] != target) {
                        ans[1] = k-1;
                        isContinueI = false;
                        break;
                    }
                }
                if(isContinueI) {
                    ans[1] = mid;
                    isContinueI = false;
                }
                for (int k = mid; k >= -1; k--) {
                    if(k == -1 || nums[k] != target) {
                        ans[0] = k+1;
                        isContinueJ = false;
                        break;
                    }
                }
                if(isContinueJ) {
                    ans[0] = mid;
                    isContinueJ = false;
                }
            }
            if(!(isContinueI) && !(isContinueJ)) {
                break;
            }
            if(i == j) {
                break;
            }
            if(isLast) {
                break;
            }
        }
        return ans;
    }


    //====================Method 02==================================================================
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int left = search(nums, target, true);
            int right = search(nums, target, false) - 1;
            if (left <= right && right < nums.length && nums[left] == target && nums[right] == target) {
                return new int[]{left, right};
            }
            return new int[]{-1, -1};
        }

        public int search(int[] nums, int target, boolean tag) {
            int left = 0, right = nums.length - 1, ans = nums.length;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (nums[mid] > target || (tag && nums[mid] >= target)) {
                    right = mid - 1;
                    ans = mid;
                } else {
                    left = mid + 1;
                }
            }
            return ans;
        }
    }
}
