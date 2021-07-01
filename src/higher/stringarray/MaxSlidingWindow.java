package higher.stringarray;/**
 * @Description
 * @author YORICHEONG
 * @create 2021-07-01 11:22
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @description: 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回滑动窗口中的最大值
 *
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * @author YORICHEONG
 * @date 2021/7/1 11:22
 * @version 1.0
 */
public class MaxSlidingWindow {

    /**
     * @description: 查找算法
     * @param: [int[], int] [nums, k] 
     * @return: int[]
     * @author YORICHEONG
     * @date: 2021/7/1 14:26
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        int[] maxArray = new int[2];
        findMax(nums,0,0+k-1,maxArray);
        result.add(maxArray[1]);
        for (int i = 1; i < nums.length; i++) {
            if(i+k-1 <= nums.length-1) {
                if(maxArray[0] >= i && maxArray[0] <= i+k-1) {
                    if( nums[i+k-1] > maxArray[1]) {
                        maxArray[0] = i+k-1;
                        maxArray[1] = nums[i+k-1];
                        result.add(maxArray[1]);
                    } else {
                        result.add(maxArray[1]);
                    }
                } else {
                    findMax(nums,i,i+k-1, maxArray);
                    result.add(maxArray[1]);
                }
            } else {
                break;
            }
        }
        int[] res = new int[result.size()];
        int index = 0;
        for (int value:
             result) {
            res[index++] = value;
        }
        return res;
    }

    /**
     * @description: 当前区间找到最大值和最大值下标的算法
     * @param: [int[], int, int, int[]] [array, left, right, maxArray] 
     * @return: void
     * @author YORICHEONG
     * @date: 2021/7/1 14:26
     */
    private void findMax(int[] array, int left ,int right, int[] maxArray) {
        int max = array[left];
        maxArray[0] = left;
        maxArray[1] = array[left];
        for(int i = left+1; i <= right; i++) {
            if (array[i] > max) {
                max = array[i];
                maxArray[0] = i;
                maxArray[1] = max;
            }
        }
    }

    /**
     * @description: 使用优先队列方法来实现
     * @param: [int[], int] [nums, k] 
     * @return: int[]
     * @author YORICHEONG
     * @date: 2021/7/1 15:04
     */
    public int[] maxSlidingWindow02(int[] nums, int k) {
        int length = nums.length;
        // 创建优先队列
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o2[0] - o1[0] : o2[1] - o1[1];
            }
        });
        // 然后初始化一个k个元素的优先队列
        for(int i = 0; i < k; i++) {
            queue.add(new int[]{nums[i],i});
        }
        int[] ans = new int[length-k+1];
        ans[0] = queue.peek()[0];

        for (int i = k; i < length; i++) {
            queue.offer(new int[]{nums[i],i});
            while(queue.peek()[1] <= i-k){
                queue.poll();
            }
            ans[i-k+1] = queue.peek()[0];
        }
        return ans;
    }
}
