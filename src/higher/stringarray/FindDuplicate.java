package higher.stringarray;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。
 * 假设 nums 只有 一个重复的整数 ，找出 这个重复的数 。
 * 你设计的解决方案必须不修改数组 nums 且只用常量级 O(1) 的额外空间
 * @author YORICHEONG
 * @date 2021/6/30 14:05
 * @version 1.0
 */
public class FindDuplicate {
    /**
     * @description:
     * @param: [int[]] [nums] 
     * @return: int
     * @author YORICHEONG
     * @date: 2021/6/30 14:05
     */
    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            if(!set.add(num)) {
                return num;
            }
        }
        return -1;
    }
    
    /**
     * @description: 使用快慢指针的方式来进行遍历
     * @param: [int[]] [nums] 
     * @return: int
     * @author YORICHEONG
     * @date: 2021/6/30 15:28
     */
    public int findDuplicate02(int[] nums) {
        int slow = 0;
        int fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = 0;
        while( slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
