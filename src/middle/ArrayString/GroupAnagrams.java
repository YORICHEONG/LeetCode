public Middle.ArrayString;

import java.util.*;

class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
    	Map<String,List<String>> map = new HashMap<String,List<String>>();

    	for(String context:strs){
    		int[] counts = new int[26];
    		int length = context.length();
    		for(int i = 0; i<length; i++){
    			counts[context.charAt(i)-'a']++;
    		}
    		StringBuffer sb = new StringBuffer();
    		for(int i = 0; i<26;i++){
    			if(counts[i]!=0){
    				sb.append((char)('a'-counts[i]));
    			}
    		}
    		String key = sb.toString();
    		List<String> list = new ArrayList<String>();
    		if(map.contain(key)){
    			list.add(context);
    		}else{
    			list = map.get(key);
    			list.add(context);
    		}
    		map.put(key,list);
    	}
    	return new ArrayList<List<String>>(map.values());
    }
