package top100;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

/**
 * @description: 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制 。
 * 实现 LRUCache 类：
 *
 * LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。
 * 当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *  
 * @author YORICHEONG
 * @date 2021/7/29 11:18
 * @version 1.0
 */

public class LRUCache {

    class DLinkNode {
        int key;
        int value;
        DLinkNode pre;
        DLinkNode next;
        public DLinkNode(){}
        public DLinkNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private HashMap<Integer , DLinkNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DLinkNode head, tail;

    /**
     * @param: capacity
     * @description : 缓存初始化
     * @return :
     * @author : YORICHEONG
     * @date : 2021/7/29
     */
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size =  0;
        this.head = new DLinkNode();
        this.tail = new DLinkNode();
        head.next = tail;
        tail.pre = head;
    }

    /**
     * @param: key
     * @description : 根据key来获取元素
     * @return : int
     * @author : YORICHEONG
     * @date : 2021/7/29
     */
    public int get(int key) {
        DLinkNode node = cache.get(key);
        if(node == null) {
            return -1;
        }
        // 如果cache中有这个，那么这个节点的访问权重刷新，体现在双端队列中
        moveToHead(node);
        return node.value;
    }

    /**
     * @param: key
     * @param: value
     * @description : 添加新的节点到缓存当中
     * @return : void
     * @author : YORICHEONG
     * @date : 2021/7/29
     */
    public void put(int key, int value) {
        DLinkNode node = cache.get(key);
        if (node == null) {
            DLinkNode node1 = new DLinkNode(key, value);
            cache.put(key, node1);
            addToHead(node1);
            ++size;
            if(size > capacity) {
                DLinkNode realTail = removeTail();
                cache.remove(realTail.key);
                --size;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    /**
     * @param: node
     * @description : 将这个节点移到头节点
     * @return : void
     * @author : YORICHEONG
     * @date : 2021/7/29
     */
    private void moveToHead(DLinkNode node) {
        removeNode(node);
        addToHead(node);
    }
    
    /**
     * @param: node
     * @description : 在头节点之后添加一个节点
     * @return : void
     * @author : YORICHEONG
     * @date : 2021/7/29
     */
    private void addToHead(DLinkNode node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    /**
     * @param: node
     * @description : 移除一个节点
     * @return : void
     * @author : YORICHEONG
     * @date : 2021/7/29
     */
    private void removeNode(DLinkNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    /**
     * @param:
     * @description : 移除最后的节点
     * @return : top100.LRUCache.DLinkNode
     * @author : YORICHEONG
     * @date : 2021/7/29
     */
    private DLinkNode removeTail() {
        DLinkNode temp = tail.pre;
        removeNode(temp);
        return temp;
    }
}
