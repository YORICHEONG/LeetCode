package top100;

/**
 * @description: TODO
 * @author YORICHEONG
 * @date 2021/7/30 18:09
 * @version 1.0
 */
public class Trie {

    private Trie[] childTrie;
    private boolean isEnd;

    /** Initialize your data structure here. */
    public Trie() {
        childTrie = new Trie[26];
        isEnd = false;
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c-'a';
            if(node.childTrie[index] == null) {
                node.childTrie[index] = new Trie();
            }
            node = node.childTrie[index];
        }
        node.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    /**
     * @param: prefix
     * @description : 遍历返回
     * @return : top100.Trie
     * @author : YORICHEONG
     * @date : 2021/7/30
     */
    public Trie searchPrefix(String prefix) {
        Trie node = this;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            int index = c-'a';
            if(node.childTrie[index] == null) {
                return null;
            }
            node = node.childTrie[index];
        }
        return node;
    }

}
