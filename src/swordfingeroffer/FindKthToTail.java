package swordfingeroffer;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class FindKthToTail {

    public static void main(String[] args) {

    }

    /**
     * Return the K'th ListNode
     * @param head
     * @param k
     * @return
     */
    public static ListNode FindKthToTail(ListNode head, int k) {
        if(head == null || k < 0) {
            return null;
        }
        ListNode temp = head;
        //
        for (int i = 0; i < k - 1; i++) {
            if(temp.next != null) {
                temp = temp.next;
            } else {
                return null;
            }
        }
        //
        ListNode result = head;
        while(temp.next != null) {
            temp = temp.next;
            result = result.next;
        }

        return result;
    }

    /**
     * Reverse List by iterator method
     * @param head
     * @return
     */
    public static ListNode ReverseList1(ListNode head) {
        ListNode newHead = null;

        if(head == null || head.next == null) {
            return head;
        }

        while(head != null) {
            ListNode secondNode = head.next;
            head.next = newHead;
            newHead = head;
            head = secondNode;
        }

        return newHead;
    }

    /**
     * Reverse List by Recursion method
     * @param head
     * @return
     */
    public static ListNode ReverseList2(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode newHead = ReverseList2(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    /**
     * Merge two list sort by value
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode merge1(ListNode list1, ListNode list2) {
        ListNode newHead;
        if(list1 == null) {
            return list2;
        }
        if(list2 == null) {
            return list1;
        }
        if(list1.val < list2.val) {
            newHead = list1;
            newHead.next = merge1(list1.next, list2);
        } else {
            newHead = list2;
            newHead.next = merge1(list1, list2.next);
        }
        return newHead;
    }

    /**
     * Merge two list sort by value
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode merge2(ListNode list1, ListNode list2) {
        ListNode newHead = new ListNode(-1);
        newHead.next = null;
        ListNode root = newHead;

        //
        while(list1 != null && list2 != null) {
            if(list1.val <= list2.val) {
                newHead.next = list1;
                newHead = list1;
                list1 = list1.next;
            } else {
                newHead.next = list2;
                newHead = list2;
                list2 = list2.next;
            }
        }

        //
        if(list1 != null) {
            newHead.next = list1;
        }
        if(list2 != null) {
            newHead.next = list2;
        }

        return root.next;
    }

    /**
     * List node
     */
    static class ListNode{
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
