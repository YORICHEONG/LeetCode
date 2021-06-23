package middle.SortSearch;
import java.rmi.server.RemoteRef;
import java.util.*;

import javafx.beans.property.MapProperty;

public class TopKFrequent{
	public int[] topKFrequent(int[] nums, int k) {
		HashMap<Integer,Integer> hashMap = new HashMap();
		for(int num:nums){
			if(hashMap.containsKey(num)){
				hashMap.put(num, hashMap.get(num)+1);
			}
			hashMap.put(num,1);
		}
		
		PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>(){
			
			@Override
			public int compare(int[] a,int[] b){
				return a[1]-b[1];
			}
		});

		for(Map.Entry<Integer,Integer> entry:hashMap.entrySet()){
			int num = entry.getKey();
			int value = entry.getValue();
			if(priorityQueue.size()==k){
				//从堆中取出一个数据来进行比较大小
				if(priorityQueue.peek()[1]<value){
					priorityQueue.poll();
					priorityQueue.offer(new int[]{num,value});
				}
			}else{
				priorityQueue.offer(new int[]{num,value});
			}
		}

		int[] result = new int[k];
		for (int i = 0; i < result.length; i++) {
			result[i] = priorityQueue.poll()[0];
		}
		return result;
    }
}