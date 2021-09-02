package top100;

import java.util.*;
import java.util.Map.Entry;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @description:
 * @author YORICHEONG
 * @date 2021/8/31 17:31
 * @version 1.0
 */
public class GroupAnagrams {
    /**
     * @param: strs
     * @description : 使用排序的方法
     * @return : java.util.List<java.util.List<java.lang.String>>
     * @author : YORICHEONG
     * @date : 2021/9/1
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String s : strs) {
            char[] array = s.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(s);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}

