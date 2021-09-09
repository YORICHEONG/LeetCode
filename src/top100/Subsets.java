package top100;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @description: 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * @author YORICHEONG
 * @date 2021/9/9 10:04
 * @version 1.0
 */
public class Subsets {
    /**
     * @param: nums
     * @description : 
     * @return : java.util.List<java.util.List<java.lang.Integer>>
     * @author : YORICHEONG
     * @date : 2021/9/9
     */
    public List<List<Integer>> subsets(int[] nums) {
        if(nums.length == 0) {
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<Integer>());
        for (int i = 0; i < nums.length; i++) {
            iteratorList(list, nums[i]);
        }
        return list;
    }
    /**
     * @param: lists
     * @param: newValue
     * @description :
     * @return : void
     * @author : YORICHEONG
     * @date : 2021/9/9
     */
    private void iteratorList(List<List<Integer>> lists, int newValue) {
        List<List<Integer>> tempLists = new ArrayList<>(lists.size());
        List<Integer> tempList = null;
        for (List<Integer> list : lists) {
            tempList = new ArrayList<>();
            tempList.addAll(list);
            tempList.add(newValue);
            tempLists.add(tempList);
        }
        lists.addAll(tempLists);
    }

}
