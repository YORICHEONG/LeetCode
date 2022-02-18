package byday.code_2021.code_11.day_02;

/**
 * @Description 给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * 假设你总是可以到达数组的最后一个位置。
 * @Author YORICHEONG
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2021-11-02
 */
public class Jump {
    /**
     * 使用贪心算法来进行遍历查找
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        int end = 0;
        int maxLength = 0;
        int step = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            // 当前能跳的最大的边界
            maxLength = Math.max(maxLength, i + nums[i]);
            // 判断当前的位置是否到了此时最大的边界
            if(end == i) {
                end = maxLength;
                step++;
            }
        }
        return step;
    }
}
