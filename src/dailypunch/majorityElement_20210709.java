package dailypunch;

import java.util.HashMap;
import java.util.Map;
/**
 * @author YORICHEONG
 * @date 2021-07-09 09:35:39
 * @description 数组中占比超过一半的元素称之为主要元素。给你一个 整数 数组，找出其中的主要元素。若没有，返回 -1 。请设计时间复杂度为 O(N) 、空间复杂度为 O(1) 的解决方案。
 * 
 */
public class majorityElement_20210709 {
    /**
     * 获取一个数组中的过半的元素，如果没有就直接返回-1
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> countMap = new HashMap<Integer,Integer>(nums.length);
        int state = nums.length/2;
        for (int i = 0; i < nums.length; i++) {
            countMap.put(nums[i],countMap.getOrDefault(nums[i],0)+1);
        }
        for(Map.Entry<Integer,Integer> entry : countMap.entrySet()) {
            if(countMap.get(entry.getKey()) > state) {
                return entry.getKey();
            }
        }
        return -1;
    }


    // [1,2,5,9,5,9,5,5,5]
    /**
     * 福尔摩斯投票法原理实现查找过半数
     * @param nums
     * @return
     */
    public int majorityElement02(int[] nums) {
        // 设置一个候选人prev 和一个计数器 count
        int prev = -1;
        int count = 0;

        // 对所有人来进行一个候选判断计数
        for(int i : nums) {
            // 如果count抵消为0，则更换候选人
            if(count == 0) {
                count++;
                prev = i;
            // 如果找到新的当前候选人，count加1
            } else if(prev == i) {
                count++;
            // 如果当前遍历的人不是候选人就count减1
            } else if(prev != i) {
                count--;
            }
        }
        // 然后来统计找出的候选人数字是否是真的大于当前数组中所有数字的一半
        if(count > 0) {
            int n = 0;
            for (int i : nums) {
                if(i == prev) {
                    n++;
                }
            }
            if(n > nums.length/2 ){
                return prev;
            }
        }
        return -1;
    }
}
