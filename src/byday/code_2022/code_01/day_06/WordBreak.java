package byday.code_2022.code_01.day_06;

import java.util.*;

/**
 * @Description Given a string s and a dictionary of strings wordDict,
 * add spaces in s to construct a sentence where each word is a valid dictionary word.
 * Return all such possible sentences in any order.
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 * @Author YORICHEONG yoricheong@gmail.com precent99@qq.com
 * @Date 2022/1/6 11:00
 * @Tags
 **/
public class WordBreak {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        String s = "catsanddog";
        List<String> dict = new ArrayList<>();
        dict.add("cat");
        dict.add("cats");
        dict.add("and");
        dict.add("sand");
        dict.add("dog");

        solution.wordBreak(s, dict);
    }
}

/**
 * @Description: Get the answer form the office
 * @Author: YORICHEONG
 * @Date: 11:22 2022/1/6
 **/
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<Integer, List<List<String>>> map = new HashMap<Integer, List<List<String>>>();
        List<List<String>> wordBreaks = backtrack(s, s.length(), new HashSet<String>(wordDict), 0, map);
        List<String> breakList = new LinkedList<String>();
        for (List<String> wordBreak : wordBreaks) {
            breakList.add(String.join(" ", wordBreak));
        }
        return breakList;
    }

    public List<List<String>> backtrack(String s, int length, Set<String> wordSet, int index, Map<Integer, List<List<String>>> map) {
        if (!map.containsKey(index)) {
            List<List<String>> wordBreaks = new LinkedList<List<String>>();
            if (index == length) {
                wordBreaks.add(new LinkedList<String>());
            }
            for (int i = index + 1; i <= length; i++) {
                String word = s.substring(index, i);
                if (wordSet.contains(word)) {
                    List<List<String>> nextWordBreaks = backtrack(s, length, wordSet, i, map);
                    for (List<String> nextWordBreak : nextWordBreaks) {
                        LinkedList<String> wordBreak = new LinkedList<String>(nextWordBreak);
                        wordBreak.offerFirst(word);
                        wordBreaks.add(wordBreak);
                    }
                }
            }
            map.put(index, wordBreaks);
        }
        return map.get(index);
    }
}

/**
 * @Description: get the answer from the comment
 * @Author: YORICHEONG 
 * @Date: 11:26 2022/1/6
 **/
class Solution2 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        List<String> ans = new ArrayList<>();
        dfs(s, ans, 0, new LinkedList<>(), set);
        return ans;
    }

    public void dfs(String s, List<String> ans, int idx, Deque<String> path, Set<String> set) {
        if (idx == s.length()) {
            ans.add(String.join(" ", path));
            return;
        }
        for (int i = idx; i < s.length(); i++) {
            String str = s.substring(idx, i + 1);
            if (set.contains(str)) {
                path.add(str);
                dfs(s, ans, i + 1, path, set);
                path.removeLast();
            }
        }
    }
}