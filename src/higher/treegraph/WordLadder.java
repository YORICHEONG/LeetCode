package higher.treegraph;/**
 * @Description
 * @author YORICHEONG
 * @create 2021-07-05 14:04
 */

import java.util.*;

/**
 * @description:
 * A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
 * Every adjacent pair of words differs by a single letter.
 * Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
 * sk == endWord
 * Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.
 *
 * Example 1:
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * Output: 5
 * Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
 *
 *
 * @author YORICHEONG
 * @date 2021/7/5 14:04
 * @version 1.0
 */
public class WordLadder {
    /**
     * @description: BFS METHOD
     * @param: [java.lang.String, java.lang.String, List<String>] [beginWord, endWord, wordList] 
     * @return: int
     * @author YORICHEONG
     * @date: 2021/7/5 14:04
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // create to hashset to store the  beginword and endword
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();

        int len = 1;
        int strLength = beginWord.length();
        // create hashset to record the is visited word
        HashSet<String> visited = new HashSet<>();

        beginSet.add(beginWord);
        endSet.add(endWord);

        if(!wordList.contains(endWord)) {
            return 0;
        }

        // join the iterator
        while(!beginSet.isEmpty() && !endSet.isEmpty()) {
            // if begin set length smaller than end set length do a exchange
            if(beginSet.size() > endSet.size()) {
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }
            // create hashset to store this iterator string
            Set<String> temp = new HashSet<>();

            for(String context : beginSet) {
                char[] chs = context.toCharArray();
                for (int i = 0; i < chs.length; i++) {
                    // for each char in i index to a-z replace and do compare
                    for (char c = 'a'; c <= 'z' ; c++) {
                        // record the primitive char
                        char old = chs[i];
                        // replace this index char to iterator char
                        chs[i] = c;

                        String target = String.valueOf(chs);

                        // do a compare with the endset
                        if(endSet.contains(target)) {
                            // if right direct return the result
                            return len+1;
                        }
                        // if didn't match
                        // object the visited set contain or not and wordList contains it
                        if(!visited.contains(target) && wordList.contains(target)) {
                            // add the current iterator string to temp set
                            temp.add(target);
                            // add the current iterator string to visited set
                            visited.add(target);
                        }
                        // recover the replace char
                        chs[i] = old;
                    }
                }
            }
            // when iterator the all begin set and no found the string can direct transfer to the target string
            // we exchange the begin set with the temp set from the last iterator obtain
            beginSet = temp;
            // and add the length
            len++;

            // we need to know all of the current begin set contain the all the change result from the last begin set word
            // and also contained by wordlist

            // so at the last iterator we need to object the begin set and end set who short length
            // chose short length set as the to be compared
        }
        return 0;
    }
}
class Solution {
    Map<String, Integer> wordId = new HashMap<String, Integer>();
    List<List<Integer>> edge = new ArrayList<List<Integer>>();
    int nodeNum = 0;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        for (String word : wordList) {
            addEdge(word);
        }
        addEdge(beginWord);
        if (!wordId.containsKey(endWord)) {
            return 0;
        }
        int[] dis = new int[nodeNum];
        Arrays.fill(dis, Integer.MAX_VALUE);
        int beginId = wordId.get(beginWord), endId = wordId.get(endWord);
        dis[beginId] = 0;

        Queue<Integer> que = new LinkedList<Integer>();
        que.offer(beginId);
        while (!que.isEmpty()) {
            int x = que.poll();
            if (x == endId) {
                return dis[endId] / 2 + 1;
            }
            for (int it : edge.get(x)) {
                if (dis[it] == Integer.MAX_VALUE) {
                    dis[it] = dis[x] + 1;
                    que.offer(it);
                }
            }
        }
        return 0;
    }

    public void addEdge(String word) {
        addWord(word);
        int id1 = wordId.get(word);
        char[] array = word.toCharArray();
        int length = array.length;
        for (int i = 0; i < length; ++i) {
            char tmp = array[i];
            array[i] = '*';
            String newWord = new String(array);
            addWord(newWord);
            int id2 = wordId.get(newWord);
            edge.get(id1).add(id2);
            edge.get(id2).add(id1);
            array[i] = tmp;
        }
    }

    public void addWord(String word) {
        if (!wordId.containsKey(word)) {
            wordId.put(word, nodeNum++);
            edge.add(new ArrayList<Integer>());
        }
    }
}

