package middle.ArrayString;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
    	Map<String,List<String>> map = new HashMap<String,List<String>>();
      List<List<String>> result  = new ArrayList<List<String>>();
    	for(String context:strs){
    		int[] counts = new int[26];//创建一个记录26字符的数组
    		int length = context.length();
    		for(int i = 0; i<length; i++){
    			counts[context.charAt(i)-'a']++;//将当前这个字母的下标设置加1
    		}
       
    		StringBuffer sb = new StringBuffer();
    		for(int i = 0; i<26;i++){
    			if(counts[i]!=0){
            for(int j =0; j<counts[i]; j++){//遍历这个纪录数组，然后将对应的位置的，用StringBuffer添加对应的数和次数
              sb.append((char)('a'+i));
            }
    			}
    		}
    		String key = sb.toString();//根据StringBuffer获得一个String
    		if(!map.containsKey(key)){//进行map的put操作
    			map.put(key,new ArrayList<String>());
    		}
        map.get(key).add(context);
    	}
    	for(List<String> temp:map.values()){
        result.add(temp);
      }
      return result;
    }

    public static void main(String[] args) {
      String[] context = {"eat","tea","tan","ate","nat","bat"};
      new GroupAnagrams().groupAnagrams(context);
    }
}