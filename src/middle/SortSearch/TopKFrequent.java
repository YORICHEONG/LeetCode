package middle.SortSearch;
import java.util.*;

public class TopKFrequent{
	public int[] topKFrequent(int[] nums, int k) {
		//首先创建一个基于map的数字和次数出现对应表
		List<Integer> result = new ArrayList<Integer>();
		Map<Integer,Integer> countMap = new HashMap();
		for(int num:nums){
			if(countMap.containsKey(num)){
				countMap.put(num,countMap.get(num)+1);
			}else{
				countMap.put(num,1);
			}
		}
		//然后进行桶排序
		int[] array = new int[nums.length+1];
		for(int key:map.keySet()){
			// 获取出现的次数作为下标
            int i = map.get(key);
           	array[i] = key;
		}
		for(int i = array.length()-1&&result.size()<k; i>=0; i++){
			if(list[i]==0){
				continue;
			}
			result.addAll(array[i]);
		}
    }
}