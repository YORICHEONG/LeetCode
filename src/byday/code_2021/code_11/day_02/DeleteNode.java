package byday.code_2021.code_11.day_02;

import middle.list.ListNode;

/**
 * @Description 请编写一个函数，用于 删除单链表中某个特定节点 。
 * 在设计函数时需要注意，你无法访问链表的头节点 head ，只能直接访问 要被删除的节点 。
 * 题目数据保证需要删除的节点 不是末尾节点 。
 * @Author YORICHEONG
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2021-11-02
 */
public class DeleteNode {
    /**
     *
     * @param node
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
