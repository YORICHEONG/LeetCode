package byday.code_2021_12_28;

import java.util.HashMap;
import java.util.Stack;

/**
 * @Description Given an array of strings words representing an English Dictionary,
 * return the longest word in words that can be built one character at a time by other words in words.
 * If there is more than one possible answer, return the longest word with the smallest lexicographical order.
 * If there is no answer, return the empty string.
 * @Author YORICHEONG yoricheong@gmail.com precent99@qq.com
 * @Date 2021/12/29 14:04
 * @Tags
 **/
public class LongestWord {
    
    /**
     * @Description:
     * @Author: YORICHEONG 
     * @Date: 14:05 2021/12/29
     **/
    public String longestWord(String[] words) {
        WordTrie wordTrie = new WordTrie();
        int index = 0;
        for(String word : words) {
            wordTrie.insert(word, ++index);
        }
        wordTrie.words = words;
        return null;
    }
}

/**
 * 前缀树的节点
 */
class Node {
    Character value;

    HashMap<Character, Node> childTrie;

    int isEnd;

    public Node(Character value) {
        this.value = value;
    }
}

/**
 * 前缀树
 */
class WordTrie {
    Node root;

    String[] words;

    public WordTrie() {
        root = new Node('0');
    }
    
    /**
     * @Description: 插入一个字符来到前缀树中
     * @Author: YORICHEONG 
     * @Date: 17:41 2021/12/29
     **/
    public void insert(String word, int index) {
        // 每次从根节点开始来进行插入
        Node current = root;
        for(Character c : word.toCharArray()) {
            // 如果
            current.childTrie.putIfAbsent(c, new Node(c));
            current = current.childTrie.get(c);
        }
        // 记录当前这个树记录的是字符数组的第几个字符
        current.isEnd = index;
    }
    
    /**
     * @Description: 进行遍历
     * @Author: YORICHEONG 
     * @Date: 14:27 2021/12/29
     **/
    public String dfs() {
       String ans = "";
       Stack<Node> stack = new Stack<>();
       stack.push(root);
       while(!stack.isEmpty()) {
           Node node = stack.pop();
           if(node.isEnd > 0 || node == root) {
               if(node != root) {
                   String word = words[node.isEnd - 1];
                   if(word.length() > ans.length()
                           || word.length() == ans.length() && word.compareTo(ans) < 0) {
                       ans = word;
                   }
               }
               for(Node nei : node.childTrie.values()) {
                   stack.push(nei);
               }
           }
       }
       return ans;
    }
}
