package byday.code_2022.code_01.day_05;

import byday.code_2021.code_12.day_08.Trie;

import java.util.Map;

/**
 * @Description
 * @Author YORICHEONG yoricheong@gmail.com precent99@qq.com
 * @Date 2022/1/5 11:06
 * @Tags
 **/
public class WordDictionary {
    // 创建一个节点作为字典树的根节点
    Trie root;

    public WordDictionary() {
        root = new Trie();
    }

    public void addWord(String word) {
        root.insert(word);
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int index, Trie root) {
        // 当遍历的位置到达了指定的长度，判断当前这个位置是否是一个完整的单词
        if(index == word.length()) {
            return root.isEnd;
        }
        char c = word.charAt(index);
        if(Character.isLetter(c)) { // 如果当前遍历的字符是字母来的，就可以继续进行遍历下去
            Trie current = root.container.get(c);
            if(null != current && dfs(word, index + 1, current)) {
                return true;
            }
        } else {
            // 如果当前遍历不是字符，而是一个通用的*，就需要进行一个层次的遍历
            for(Map.Entry<Character, Trie> entry : root.container.entrySet()) {
                // 遍历当前层所有的节点
                Trie currentTrie = entry.getValue();
                // 然后再取任意一个节点的所有子节点来进行遍历
                if(null != currentTrie && dfs(word, index + 1, currentTrie)) {
                    return true;
                }
            }
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */