package byday.code_2022.code_01.day_05;

import byday.code_2021.code_12.day_08.Trie;

import java.util.*;

/**
 * @Description
 * @Author YORICHEONG yoricheong@gmail.com precent99@qq.com
 * @Date 2022/1/5 14:16
 * @Tags
 **/
public class ReplaceWords {
    // 前缀树的根节点
    Trie root = new Trie();

    /**
     * @Description:
     * @Author: YORICHEONG 
     * @Date: 14:17 2022/1/5
     **/
    public String replaceWords(List<String> dictionary, String sentence) {
        // 创建一个Map用来记录每个词对应的最短前缀
        Map<String, String> minPre = new HashMap<>();
        // 首先将所有的前缀节点插入到前缀树仲
        for(String word : dictionary) {
            root.insert(word);
        }
        // 将要转换的String字符串进行一个转行
        String[] sentenceList = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for(String s : sentenceList) {// 循环遍历这个字符串
            minPre.put(s, s);
            int index = 1;
            while(index < s.length()) {
                String temp = s.substring(0, s.length() - index);
                if(root.search(temp)) {
                    minPre.put(s, temp);
                }
                index++;
            }
            sb.append(minPre.get(s)).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    class Solution1 {
        /**
         * @Description: 使用hash前缀的方法来进行判断
         * @Author: YORICHEONG 
         * @Date: 13:51 2022/1/13
         **/
        public String replaceWords(List<String> dictionary, String sentence) {
            Set<String> rootSet = new HashSet<>(dictionary);
            StringBuilder sb = new StringBuilder();
            // 然后将sentence来进行分割，然后就可以切换成为一段段的
            for(String s : sentence.split("\\s+")) {
                String prefix = "";
                for (int i = 1; i <= s.length(); i++) {
                    prefix = s.substring(0, i);
                    if(rootSet.contains(prefix)){
                        break;
                    }
                }
                if(sb.length() > 0) {
                    sb.append(" ");
                }
                sb.append(prefix);
            }
            return sb.toString();
        }
    }

    class Solution2 {
        public String replaceWords(List<String> roots, String sentence) {
            TrieNode trie = new TrieNode();
            for (String root: roots) {
                TrieNode cur = trie;
                for (char letter: root.toCharArray()) {
                    if (cur.children[letter - 'a'] == null)
                        cur.children[letter - 'a'] = new TrieNode();
                    cur = cur.children[letter - 'a'];
                }
                cur.word = root;
            }

            StringBuilder ans = new StringBuilder();

            for (String word: sentence.split("\\s+")) {
                if (ans.length() > 0)
                    ans.append(" ");

                TrieNode cur = trie;
                for (char letter: word.toCharArray()) {
                    if (cur.children[letter - 'a'] == null || cur.word != null)
                        break;
                    cur = cur.children[letter - 'a'];
                }
                ans.append(cur.word != null ? cur.word : word);
            }
            return ans.toString();
        }
    }

    class TrieNode {
        TrieNode[] children;
        String word;
        TrieNode() {
            children = new TrieNode[26];
        }
    }
}

/**
 * 在英语中，有一个叫做词根(root) 的概念，它可以跟着其他一些词组成另一个较长的单词——我们称这个词为继承词(successor)。
 * 例如，词根an，跟随着单词other(其他)，可以形成新的单词another(另一个)。
 * 现在，给定一个由许多词根组成的词典和一个句子，需要将句子中的所有继承词用词根替换掉。如果继承词有许多可以形成它的词根，则用最短的词根替换它。
 * 需要输出替换之后的句子。
 */