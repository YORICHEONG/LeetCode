package top100;

import middle.list.ListNode;

/**
 * @description: 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * @author YORICHEONG
 * @date 2021/7/29 10:47
 * @version 1.0
 */
public class DetectCycle {
    /**
     * 方法一：直接将每个遍历的节点直接记录下来，然后遇到了就是重复的节点
     * 方法二：使用快慢指针，首先使用两个指针分别代表快慢，然后他们会在环中相遇，然后这个时间再创建一个节点，然后再进行遍历
     *        然后相交的点就是入环的第一个节点
     * 方法三：通过内存地址来判断，链表的内存申请从低到高
     */
    /**
     * @param: head
     * @description : 环形链表探测方法
     * @return : ListNode
     * @author : YORICHEONG
     * @date : 2021/7/29
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null) {
            slow = slow.next;
            if(fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if(fast == slow) {
                ListNode pre = head;
                while(pre != slow) {
                    pre = pre.next;
                    slow = slow.next;
                }
                return pre;
            }
        }
        return null;
    }
}
