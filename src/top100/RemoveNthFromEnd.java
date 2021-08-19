package top100;

import middle.list.ListNode;

/**
 * @description: 删除倒数第n个节点
 * @author YORICHEONG
 * @date 2021/8/19 9:06
 * @version 1.0
 */
public class RemoveNthFromEnd {
    /**
     * @param: head
     * @param: n
     * @description : 使用快慢指针
     * @return : middle.list.ListNode
     * @author : YORICHEONG
     * @date : 2021/8/19
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode fast = head;
        ListNode slow = node;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while(fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        ListNode ans = node.next;
        return ans;
    }
}
