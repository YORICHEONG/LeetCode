package top100;

/**
 * @description: TODO
 * @author YORICHEONG
 * @date 2021/7/30 16:52
 * @version 1.0
 */
public class MajorityElement {
    /**
     * @param: nums
     * @description : 使用摩尔投票法
     * @return : int
     * @author : YORICHEONG
     * @date : 2021/7/30
     */
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
}
