package byday.code_2022_01_13;

/**
 * @Description 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。
 *
 * 你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换
 * @Author YORICHEONG yoricheong@gmail.com precent99@qq.com
 * @Date 2022/1/13 10:34
 * @Tags
 **/
public class SwapPairs {

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    class Solution {
        // 给链表头节点再添加一个前节点，然后基于这个前节点来进行遍历，给这种凭空或者为了实现功能而创建的点称之为哑点
        public ListNode swapPairs(ListNode head) {
            ListNode root = new ListNode();
            root.next = head;
            ListNode p = root; // 在原来的首节点添加一个头节点
            // 然后两两节点来进行遍历
            while (head != null && head.next != null) {
                ListNode tnode = head.next.next; // 第三个节点
                p.next = head.next; // 首届点然后改成原来的第二个节点
                p.next.next = head; //　
                p.next.next.next = tnode; // 第三个节点
                head = tnode;
                p = p.next.next;
            }
            return root.next;
        }
    }

    class Solution2 {
        /**
         * @Description: 采用递归的方式来进行，直到没有两个链接点没有交换
         * @Author: YORICHEONG 
         * @Date: 11:14 2022/1/13
         **/
        public ListNode swapPairs(ListNode head) {
            if(null == head || null == head.next) {
                return head;
            }
            ListNode newHead = head.next;
            head.next = swapPairs(newHead.next);
            newHead.next = head;
            return newHead;
        }
    }
}
