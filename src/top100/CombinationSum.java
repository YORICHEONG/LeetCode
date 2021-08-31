package top100;

import java.util.*;

/**
 * @description: 给定一个无重复元素的正整数数组 candidates 和一个正整数 target 
 * 找出 candidates 中所有可以使数字和为目标数 target 的唯一组合。
 * candidates 中的数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是唯一的。 
 * 对于给定的输入，保证和为 target 的唯一组合数少于 150 个。
 * @author YORICHEONG
 * @date 2021/8/30 9:35
 * @version 1.0
 */
public class CombinationSum {
    //========================Method 01======================================//
    
    /**
     * @param: candidates
     * @param: target
     * @description : 采用回溯加剪枝的方法来进行操作
     * @return : java.util.List<java.util.List<java.lang.Integer>>
     * @author : YORICHEONG
     * @date : 2021/8/30
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int length = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if(length == 0) {
            return res;
        }
        // 然后进行排序，排序是剪枝的前提
        Arrays.sort(candidates);
        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates, 0, length, target, path, res);

        return res;
    }
    
    /**
     * @param: candidates
     * @param: begin
     * @param: length
     * @param: target
     * @param: path
     * @param: res
     * @description : 回溯算法加剪枝
     * @return : void
     * @author : YORICHEONG
     * @date : 2021/8/30
     */
    private void dfs(int[] candidates, int begin, int length, int target, Deque<Integer> path, List<List<Integer>> res){
        if(target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i < length; i++) {
            // 剪枝代码
            if(target - candidates[i] < 0) {
                break;
            }
            path.addLast(candidates[i]);
            dfs(candidates, i, length, target - candidates[i], path, res);
            path.removeLast();
        }
    }

}
