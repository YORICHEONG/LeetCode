package Begin.link;
import java.util.Stack;
/**
 * 请判断一个链表是否为回文链表。
 * 
 */
public class IsPalindrome {
  public boolean solution(ListNode head){
    if(head==null){
      return true;
    }
    //首先创建一个栈
    Stack<ListNode> stack = new Stack<>();
    ListNode temp = head;
    //首先将所有的ListNodo添加到stack中
    while(temp!=null){
      stack.push(temp);
      temp = temp.next;
    }
    if(stack.isEmpty()){
      return true;
    }
    temp = head;
    while(temp!=null){
      ListNode cur = stack.pop();
      if(cur.val != temp.val){
        return false;
      }
      temp = temp.next;
    }
    return true;
  }
  public static void main(String[] args) {
    ListNode head1 = new ListNode(0);
    ListNode head2 = new ListNode(0);
    ListNode head3 = new ListNode(0);
    ListNode head4 = new ListNode(0);
    ListNode head5 = new ListNode(0);
    ListNode head6 = new ListNode(0);

    head1.next = head2;
    head2.next = head3;
    head3.next = head4;
    head4.next = head5;
    head5.next = head6;

    boolean result = new IsPalindrome().solution(head1);
    System.out.println(result);
  }
}
 