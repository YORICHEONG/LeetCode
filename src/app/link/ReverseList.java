package app.link;
import java.util.Stack;
/**
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表
 */
public class ReverseList {
  
  /**
   * 使用栈来进行一个逆序
   * @param head
   * @return
   */
  public ListNode solution_01(ListNode head){
    Stack<ListNode> stack = new Stack<>();
    while(head!=null){
      stack.push(head);
      head = head.next;
    }
    if(stack.isEmpty()){
      return null;
    }
    ListNode newHead = stack.pop();
    ListNode temp = newHead;

    while(!stack.isEmpty()){
      ListNode current = stack.pop();
      newHead.next = current;
      newHead = newHead.next;
    }
    newHead.next = null;
    return temp;
  }
}
