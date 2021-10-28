package byday.code_2021_10_28;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * @Author YORICHEONG yoricheong@gmail.com precent99@qq.com
 * @Date 2021/10/28 10:17
 * @Tags
 **/
public class PermuteUnique {
    boolean[] vis;
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> perm = new ArrayList<Integer>();
        vis = new boolean[nums.length];
        // 这个是一个进行了排序的数组
        Arrays.sort(nums);
        backtrack(nums, ans, 0, perm);
        return ans;
    }

    /**
     * Example：[1,1,2]
     * [[1,1,2],
     *  [1,2,1],
     *  [2,1,1]]
     */

    /**
     * @Description: 使用回溯的方法
     * @Author: YORICHEONG
     * @Date: 10:32 2021/10/28
     **/
    public void backtrack(int[] nums, List<List<Integer>> ans, int idx, List<Integer> perm) {
        // 如果当前的组成的数组的长度达到了这个长度，就添加到最终的答案容器中,然后返回这个方法
        if (idx == nums.length) {
            ans.add(new ArrayList<Integer>(perm));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            // 这是一个剪枝操作，提高效率
            // 如果没有这个剪枝操作，如果要求去重，那么可以直接使用Set来进行去重
            // 保证在填第 n 个数的时候重复数字只会被填入一次即可
            // 保证从数组中任何一个数开始，都是从左到右来插入数据
            if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
                continue;
            }
            perm.add(nums[i]);
            vis[i] = true;
            backtrack(nums, ans, idx + 1, perm);
            vis[i] = false;
            perm.remove(idx);
        }
    }

    public static void main(String[] args) {
        new PermuteUnique().permuteUnique(new int[]{1,1,2});
    }

    class solution {
            boolean[] vis;

            public List<List<Integer>> permuteUnique(int[] nums) {
                List<List<Integer>> ans = new ArrayList<List<Integer>>();
                List<Integer> perm = new ArrayList<Integer>();
                vis = new boolean[nums.length];
                // 这个是一个进行了排序的数组
                Arrays.sort(nums);
                backtrack(nums, ans, 0, perm);
                return ans;
            }

            /**
             * Example：[1,1,2]
             * [[1,1,2],
             *  [1,2,1],
             *  [2,1,1]]
             */

            /**
             * @Description: 使用回溯的方法
             * @Author: YORICHEONG 
             * @Date: 10:32 2021/10/28
             **/
            public void backtrack(int[] nums, List<List<Integer>> ans, int idx, List<Integer> perm) {
                // 如果当前的组成的数组的长度达到了这个长度，就添加到最终的答案容器中,然后返回这个方法
                if (idx == nums.length) {
                    ans.add(new ArrayList<Integer>(perm));
                    return;
                }
                for (int i = 0; i < nums.length; ++i) {
                    // 这是一个剪枝操作，提高效率
                    // 如果没有这个剪枝操作，如果要求去重，那么可以直接使用Set来进行去重
                    // 保证在填第 n 个数的时候重复数字只会被填入一次即可
                    // 保证从数组中任何一个数开始，都是从左到右来插入数据
                    if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
                        continue;
                    }
                    perm.add(nums[i]);
                    vis[i] = true;
                    backtrack(nums, ans, idx + 1, perm);
                    vis[i] = false;
                    perm.remove(idx);
                }
            }
        }
}
