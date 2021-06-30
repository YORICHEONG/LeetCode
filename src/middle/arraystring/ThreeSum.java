package middle.arraystring;
import java.util.*;

public class ThreeSum {
  public List<List<Integer>> threeSum(int[] nums) {
    //创建一个返回对象
    List<List<Integer>> resultList = new ArrayList<List<Integer>>();
    //对数组进行一个排序
    Arrays.sort(nums);
    //然后进行一个遍历
    for(int i= 0; i<nums.length-2; i++){
      if(i==0||nums[i]!=nums[i-1]){//如果是当前是第一个数，或者当前数与前一个数并不相同就可以进入操作
        int start = i+1;//假定一个数是当前数的后一个数
        int end = nums.length-1;//一个数是最后的数
        while(start<end){
          if(nums[i]+nums[start]+nums[end]==0){//三个数相加相同
            List<Integer> list = new ArrayList<Integer>();
            list.add(nums[i]);
            list.add(nums[start]);
            list.add(nums[end]);
            resultList.add(list);//然后将创建好的List添加到resultlist中
            start++;
            end--;
            //循环是为了防止后面的这两个数重复
            while(start<end&&nums[start]==nums[start-1]){
              start++;
            }
            while(start<end&&nums[end]==nums[end+1]){
              end--;
            }
          }else if(nums[i]+nums[start]+nums[end]<0){
            start++;
          }else{
            end--;
          }
        }
      }
    }
    return resultList;
  }
}
