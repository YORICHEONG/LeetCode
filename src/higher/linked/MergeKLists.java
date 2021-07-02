package higher.linked;/**
 * @Description
 * @author YORICHEONG
 * @create 2021-07-02 11:22
 */

import com.sun.deploy.util.LinkMouseListener;
import middle.list.ListNode;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @description: 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * @author YORICHEONG
 * @date 2021/7/2 11:22
 * @version 1.0
 */
public class MergeKLists {
    /**
     * @description:
     * @param: [middle.list.ListNode[]] [lists] 
     * @return: middle.list.ListNode
     * @author YORICHEONG
     * @date: 2021/7/2 14:55
     */
    public ListNode mergeKLists(ListNode[] lists) {

        if(lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val- o2.val;
            }
        });

        for(ListNode node : lists) {
            if(node != null) {
                queue.add(node);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;

        while(!queue.isEmpty()) {
            p.next = queue.poll();
            p = p.next;
            if(p.next != null) {
                queue.add(p.next);
            }
        }

        return dummy.next;
    }
}
