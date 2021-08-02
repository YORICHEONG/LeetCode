package top100;

import middle.list.ListNode;

/**
 * @description: TODO
 * @author YORICHEONG
 * @date 2021/7/30 16:40
 * @version 1.0
 */
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
