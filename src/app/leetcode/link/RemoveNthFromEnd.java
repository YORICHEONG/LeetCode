package app.leetcode.link;
/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 进阶：你能尝试使用一趟扫描实现吗
 */
public class RemoveNthFromEnd {
  /**
   * 使用双指针的方法，一个快指针先移动的N个位置，然后再两个指针同时移动，这样就满指针就指向的是倒数的位置
   * @param head
   * @param n
   * @return
   */
  public ListNode solution(ListNode head,int n){
    ListNode fast = head;
    ListNode slow = head;

    //首先是快指针进行一个n的前进指向移动
    for(int i=0; i<n; i++){
      fast = fast.next;
    }

    //如果fast为空，就表示要删除的是头节点
    if(fast==null){
      return head.next;
    }
    //然后两个指针同时进行一个遍历
    while(fast.next!=null){
      fast = fast.next;
      slow = slow.next;
    }
    //然后获得的是倒数第n+1个节点
    slow.next = slow.next.next;
    return head;
  }
}
