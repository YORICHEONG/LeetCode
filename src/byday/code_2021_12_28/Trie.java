package byday.code_2021_12_28;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings.
 * There are various applications of this data structure, such as autocomplete and spellchecker.
 * Implement the Trie class:
 * Trie() Initializes the trie object.
 * void insert(String word) Inserts the string word into the trie.
 * boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
 * boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.
 * @Author YORICHEONG yoricheong@gmail.com precent99@qq.com
 * @Date 2021/12/29 9:52
 * @Tags
 **/
public class Trie {

    /**
     * 使用一个Map来进行初始存储，每个字母对应一个Trie
     */
    public Map<Character, Trie> container;

    /**
     * 判断当前这个位置是否是一个单词的结尾
     */
    public boolean isEnd;

    public Trie() {
        container = new HashMap<>(26);
        isEnd = false;
    }
    
    /**
     * @Description: 插入字符串到前缀树中，并在单词结束的位置打上结尾的标签
     * @Author: YORICHEONG 
     * @Date: 11:00 2021/12/29
     **/
    public void insert(String word) {
        Trie currTrie = this;
        for(Character c : word.toCharArray()) {
            if(currTrie.container.containsKey(c)) {
                currTrie = currTrie.container.get(c);
            } else {
                currTrie.container.put(c, new Trie());
                currTrie = currTrie.container.get(c);
            }
        }
        currTrie.isEnd = true;
    }
    
    /**
     * @Description: 查找单词，判断查找的单词是否在当前的字典树中存在
     * @Author: YORICHEONG 
     * @Date: 11:00 2021/12/29
     **/
    public boolean search(String word) {
        Trie currTrie = this;
        for(Character c : word.toCharArray()) {
                 if(currTrie.container.containsKey(c)) {
                    currTrie = currTrie.container.get(c);
            } else {
                return false;
            }
        }
        return currTrie != null && currTrie.isEnd;
    }
    
    /**
     * @Description: 是否有以指定前缀存在的字符串
     * @Author: YORICHEONG 
     * @Date: 11:00 2021/12/29
     **/
    public boolean startsWith(String prefix) {
        Trie currTrie = this;
        for(Character c : prefix.toCharArray()) {
            if(currTrie.container.containsKey(c)) {
                currTrie = currTrie.container.get(c);
            } else {
                return false;
            }
        }
        return currTrie != null;
    }
}
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
