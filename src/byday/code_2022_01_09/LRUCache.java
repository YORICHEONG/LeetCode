package byday.code_2022_01_09;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 实现一个LRU算法的缓存来进行数据缓存
 * @Author YORICHEONG yoricheong@gmail.com precent99@qq.com
 * @Date 2022/1/9 9:53
 * @Tags
 **/
public class LRUCache {

    public Entry head;

    public Entry tail;

    public int capacity;

    public int size;

    public Map<Integer, Entry> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        cache = new HashMap<Integer, Entry>(capacity * 2);
        initLinkedList();
    }

    private void initLinkedList() {
        head = new Entry();
        tail = new Entry();

        head.next = tail;
        tail.pre = head;
    }

    public void put(int key, int value) {
        Entry node = cache.get(key);
        if(null != node) {
            node.value = value;
            // 将这个最新访问的节点然后存放到头节点的位置
            moveToHead(node);
            return;
        }
        // 如果当前的节点在缓存中没有存在
        // 判断当前的节点是否已经达到缓存的极限
        if(size == capacity) {
            Entry lastNode = tail.pre;
            deleteCurrentNode(lastNode);
            cache.remove(lastNode.key);
            size--;
        }
        // 加入新的节点
        Entry newNode = new Entry();
        newNode.key = key;
        newNode.value = value;
        moveNode(newNode);
        cache.put(key, newNode);
        size++;
    }

    public int get(int key) {
        Entry node = cache.get(key);
        if(null == node) {
            return -1;
        }
        moveNode(node);
        return node.value;
    }
    
    /**
     * @Description: 将当前节点移动到头节点
     * @Author: YORICHEONG 
     * @Date: 11:04 2022/1/9
     **/
    private void moveToHead(Entry node) {
        // 首先要将当前节点的位置关系进行一个删除
        deleteCurrentNode(node);
        // 让后将这个节点的关系移动到头部
        moveNode(node);
    }
    
    /**
     * @Description: 删除当前节点的上下文关系
     * @Author: YORICHEONG 
     * @Date: 11:03 2022/1/9
     **/
    private void deleteCurrentNode(Entry node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
    
    /**
     * @Description: 将当前节点移动到头节点
     * @Author: YORICHEONG 
     * @Date: 11:03 2022/1/9
     **/
    private void moveNode(Entry node) {
        head.next.pre = node;
        node.next = head.next;
        node.pre = head;
        head.next = node;
    }

    static class Entry {
        public Entry pre;

        public Entry next;

        public int key;

        public int value;

        public Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public Entry() {

        }
    }
}
