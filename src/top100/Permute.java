package top100;

import java.util.*;

/**
 * @description: 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * @author YORICHEONG
 * @date 2021/8/30 9:56
 * @version 1.0
 */
public class Permute {

    public static void main(String[] args) {
        String context = String.format("G_tob_channel_blacklist_%s", "234234").toString();
        System.out.println(context);
        //new Permute().permute(new int[]{2,3,4,5,6,1});
    }

    /**
     * @param: nums
     * @description : 回溯方法来进行组合排序
     * @return : java.util.List<java.util.List<java.lang.Integer>>
     * @author : YORICHEONG
     * @date : 2021/8/30
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> outPut = new ArrayList<>();
        outPut.toArray();
        for (int value :
             nums) {
            outPut.add(value);
        }
        int length = nums.length;
        backTrace(length, outPut, res, 0);

        return res;
    }
    
    /**
     * @param: length
     * @param: outPut
     * @param: res
     * @param: i
     * @description :
     * @return : void
     * @author : YORICHEONG
     * @date : 2021/8/30
     */
    private void backTrace(int length, List<Integer> outPut, List<List<Integer>> res, int first) {
        if(first == length) {
            res.add(new ArrayList<>(outPut));
            return;
        }
        for (int j = first; j < length; j++) {
            // 动态维护的数组
            Collections.swap(outPut, first, j);
            // 下一次操作
            backTrace(length, outPut, res, first + 1);
            // 撤销操作
            Collections.swap(outPut, first, j);
        }
    }


}
