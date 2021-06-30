package higher.stringarray;/**
 * @Description
 * @author YORICHEONG
 * @create 2021-06-30 13:43
 */

import java.util.HashSet;
import java.util.Set;

/**
 * @description: TODO
 * @author YORICHEONG
 * @date 2021/6/30 13:43
 * @version 1.0
 */
public class LongestConsecutive {
    /**
     * @description:
     * @param: [int[]] [nums] 
     * @return: int
     * @author YORICHEONG
     * @date: 2021/6/30 13:44
     */
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = moveSet(nums);
        int longStreak = 0;
        for(int num : set) {
            //　从这个set中来进行一个去重的判断
            // set中不包含num-1就是从最左的临界点开始进行遍历
            if(!set.contains(num-1)) {
                int currentNum = num;
                int currentStreak = 1;

                while(set.contains(currentNum+1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }
                longStreak = Math.max(longStreak, currentStreak);
            }
        }
        return longStreak;
    }

    /**
     * @description:
     * @param: [int[]] [nums] 
     * @return: java.util.Set<java.lang.Integer>
     * @author YORICHEONG
     * @date: 2021/6/30 13:47
     */
    private Set<Integer> moveSet(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }
        return set;
    }
}
