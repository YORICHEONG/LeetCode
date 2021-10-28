package byday.code_2021_10_28;

import java.util.Arrays;

/**
 * @Description 给定正整数 N ，我们按任何顺序（包括原始顺序）将数字重新排序，注意其前导数字不能为零。
 * 如果我们可以通过上述方式得到 2 的幂，返回 true；否则，返回 false。
 * @Author YORICHEONG yoricheong@gmail.com precent99@qq.com
 * @Date 2021/10/28 10:12
 * @Tags
 **/
public class ReorderedPowerOf2 {
    /**
     * @Description:
     * @Author: YORICHEONG 
     * @Date: 10:12 2021/10/28
     **/
    public boolean reorderedPowerOf2(int n) {

        return false;
    }

    class Solution {
        boolean[] vis;

        public boolean reorderedPowerOf2(int n) {
            char[] nums = Integer.toString(n).toCharArray();
            Arrays.sort(nums);
            vis = new boolean[nums.length];
            return backtrack(nums, 0, 0);
        }
        // [1,1,2] // 使用回溯的方法来进行
        public boolean backtrack(char[] nums, int idx, int num) {
            if (idx == nums.length) {
                return isPowerOfTwo(num);
            }
            for (int i = 0; i < nums.length; ++i) {
                // 不能有前导零
                if ((num == 0 && nums[i] == '0') || vis[i] || (i > 0 && !vis[i - 1] && nums[i] == nums[i - 1])) {
                    continue;
                }
                vis[i] = true;
                if (backtrack(nums, idx + 1, num * 10 + nums[i] - '0')) {
                    return true;
                }
                vis[i] = false;
            }
            return false;
        }
        
        /**
         * @Description: 使用二进制来进行判断这个数是否是2的幂
         * @Author: YORICHEONG 
         * @Date: 14:15 2021/10/28
         **/
        public boolean isPowerOfTwo(int n) {
            return (n & (n - 1)) == 0;
        }
    }
}
