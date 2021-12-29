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

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.startsWith("app"));

    }

    private Map<Character, Trie> container;

    private boolean isEnd;

    public Trie() {
        container = new HashMap<>(26);
        isEnd = false;
    }
    
    /**
     * @Description: 
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
     * @Description:
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
     * @Description:
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
