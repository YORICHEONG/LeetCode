package byday.code_2022_01_05;

import byday.code_2021_12_28.Trie;

import java.util.Map;

/**
 * @Description
 * @Author YORICHEONG yoricheong@gmail.com precent99@qq.com
 * @Date 2022/1/5 14:56
 * @Tags
 **/
public class MagicDictionary {

    // 前缀树的根节点
    Trie root;

    /** Initialize your data structure here. */
    public MagicDictionary() {
        root = new Trie();
    }

    public void buildDict(String[] dictionary) {
        for(String word : dictionary) {
            root.insert(word);
        }
    }
    
    /**
     * @Description: 传入的单词如果经过一次的变化就可以成为字典树里面的单词
     * @Author: YORICHEONG 
     * @Date: 15:10 2022/1/5
     **/
    public boolean search(String searchWord) {
        return dfs(searchWord, 0, 0, root);
    }
    
    /**
     * @Description: 遍历
     * @Author: YORICHEONG 
     * @Date: 18:29 2022/1/5
     **/
    private boolean dfs(String searchWord, int index, int changCount, Trie root) {
        if(index == searchWord.length()) {
            return root.isEnd && changCount == 1;
        }
        char c = searchWord.charAt(index);
        if(root.container.containsKey(c)) {
            Trie crrentNode = root.container.get(c);
            if(crrentNode != null && dfs(searchWord, index+1, changCount, crrentNode)) {
                return true;
            }
        } else if(0 == changCount) {
            for(Map.Entry<Character, Trie> entry : root.container.entrySet()) {
                Trie currentNode = entry.getValue();
                changCount = 1;
                if(null != currentNode && dfs(searchWord, index+1, changCount, currentNode)) {
                    return true;
                }
            }
        }
        return false;
    }
}
/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */

/**
 * 设计一个使用单词列表进行初始化的数据结构，单词列表中的单词 互不相同 。
 * 如果给出一个单词，请判定能否只将这个单词中一个字母换成另一个字母，使得所形成的新单词存在于已构建的神奇字典中。
 * 实现 MagicDictionary 类：
 * MagicDictionary() 初始化对象
 * void buildDict(String[] dictionary) 使用字符串数组 dictionary 设定该数据结构，dictionary 中的字符串互不相同
 * bool search(String searchWord) 给定一个字符串 searchWord ，判定能否只将字符串中 一个 字母换成另一个字母，
 * 使得所形成的新字符串能够与字典中的任一字符串匹配。如果可以，返回 true ；否则，返回 false 。
 */