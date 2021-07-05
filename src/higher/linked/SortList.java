package higher.linked;/**
 * @Description
 * @author YORICHEONG
 * @create 2021-07-05 17:22
 */

import com.sun.org.apache.xerces.internal.xni.parser.XMLErrorHandler;
import middle.list.ListNode;

import java.util.LinkedList;

/**
 * @description: Given the head of a linked list, return the list after sorting it in ascending order.
 *
 * Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?
 *
 * Input: head = [4,2,1,3]
 * Output: [1,2,3,4]
 *
 * Input: head = [-1,5,3,4,0]
 * Output: [-1,0,3,4,5]
 *
 *
 * @author YORICHEONG
 * @date 2021/7/5 17:22
 * @version 1.0
 */
public class SortList {
    /**
     * @description:
     * @param: [middle.list.ListNode] [head] 
     * @return: middle.list.ListNode
     * @author YORICHEONG
     * @date: 2021/7/5 18:06
     */
    public ListNode sortList(ListNode head) {
        // if head is null noting need to do just return direct
        if(head == null || head.next == null) {
            return head;
        }

        // cut the list to the two part
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        // sort the each half
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        // do the merge
        return merge(l1,l2);
    }
    /**
     * @description:
     * @param: [middle.list.ListNode, middle.list.ListNode] [l1, l2] 
     * @return: middle.list.ListNode
     * @author YORICHEONG
     * @date: 2021/7/5 17:52
     */
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode l = new ListNode(0);
        ListNode r = l;

        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                r.next = l1;
                l1 = l1.next;
            } else {
                r.next = l2;
                l2 = l2.next;
            }
            r = r.next;
        }
        if(l1 != null) {
            r.next = l1;
        }
        if(l2 != null) {
            r.next = l2;
        }
        return l.next;
    }
}
