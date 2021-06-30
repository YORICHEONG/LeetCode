package middle.list;

public class OddEvenList {
  public ListNode oddEvenList(ListNode head) {
    if(head==null){
      return head;
    }
    ListNode evenNode = head.next;
    ListNode odd = head;
    ListNode even = evenNode;
    while(even!=null&&even.next!=null){
      odd.next = even.next;
      odd = odd.next;
      even.next  = odd.next;
      even = even.next;
    }
    odd.next = evenNode;
    return head;
  }
}
