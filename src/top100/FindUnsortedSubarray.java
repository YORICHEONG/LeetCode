package top100;

import java.util.Arrays;

/**
 * @Description 给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 * 请你找出符合题意的 最短 子数组，并输出它的长度。
 * @Author YORICHEONG yoricheong@gmail.com precent99@qq.com
 * @Date 2021/10/25 10:03
 * @Tags
 **/
public class FindUnsortedSubarray {
    /**
     * @Description: 使用排序的方法来进行
     * @Author: YORICHEONG
     * @Date: 10:13 2021/10/25
     **/
    public int findUnsortedSubarray(int[] nums) {
        if(nums.length == 1) {
            return 0;
        }
        if(isSort(nums)) {
            return 0;
        }
        // 首先对原来的数组进行排序
        int[] newArrays = Arrays.copyOf(nums, nums.length);

        Arrays.sort(newArrays);
        int left = 0;
        int right = nums.length - 1;
        while(left < newArrays.length && right >= 0 && left < right) {
            if(nums[left] == newArrays[left]) {
                left ++;
            }
            if(nums[right] == newArrays[right]) {
                right --;
            }
            if(nums[left] != newArrays[left] && nums[right] != newArrays[right]) {
                break;
            }
        }

        return right - left + 1;
    }

    private boolean isSort(int[] array) {
        int[] copyArray = Arrays.copyOf(array, array.length);
        Arrays.sort(copyArray);
        for (int i = 0; i < array.length; i++) {
            if(copyArray[i] != array[i]) {
                return false;
            }
        }
        return true;
    }

    class solution {
        public int findUnsortedSubarray(int[] nums) {
            int n = nums.length;
            int maxn = Integer.MIN_VALUE, right = -1;
            int minn = Integer.MAX_VALUE, left = -1;
            for (int i = 0; i < n; i++) {
                if (maxn > nums[i]) {
                    right = i;
                } else {
                    maxn = nums[i];
                }
                if (minn < nums[n - i - 1]) {
                    left = n - i - 1;
                } else {
                    minn = nums[n - i - 1];
                }
            }
            return right == -1 ? 0 : right - left + 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(new FindUnsortedSubarray().findUnsortedSubarray(new int[]{2,6,4,8,10,9,15}));
    }
}
