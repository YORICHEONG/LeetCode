package middle.Backtrace;

import java.util.*;
/**
 * 
 */
public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        List<Integer> output = new ArrayList<Integer>();
        for(int num:nums){
            output.add(num);
        }
        int n = nums.length;
        backtrace(n, output, result, 0);
        return result;
    }
    /**
     * 回溯方法
     * @param n
     * @param output
     * @param res
     * @param first
     */
    private void backtrace(int n,List<Integer> output,List<List<Integer>> res,int first){
        if(first==n){
            res.add(new ArrayList<Integer>(output));
        }
        for(int i = first; i<n; i++){
            Collections.swap(output, i, first);
            backtrace(n, output, res, first+1);
            Collections.swap(output, first,i);
        }
    }
}
