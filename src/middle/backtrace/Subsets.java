package middle.backtrace;
import java.util.*;
public class Subsets {
    List<Integer> t = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    public List<List<Integer>> subsets(int[] nums) {
        dfs(0,nums);
        return ans;
    }
    private void dfs(int current,int[] nums){
        if(current==nums.length){
            ans.add(new ArrayList<Integer>(t));
            return;
        }
        t.add(nums[current]);
        dfs(current + 1, nums);
        t.remove(t.size() - 1);
        dfs(current + 1, nums);
    }
}
