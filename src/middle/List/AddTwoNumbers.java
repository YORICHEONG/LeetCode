package middle.List;

public class AddTwoNumbers {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

    ListNode head = new ListNode(0);
    ListNode tail = head;
    int carray = 0;
    while(l1!=null||l2!=null||carray>0){
      int v1 = 0;
      int v2 = 0;
      if(l1!=null){
        v1 = l1.val; 
        l1 = l1.next;
      }
      if(l2!=null){
        v2 = l2.val;
        l2 = l2.next;
      }
      int sum = v1+v2+carray;
      int val = sum%10;
      carray = sum/10;
      ListNode current = new ListNode(val);
      tail.next = current;
      tail = tail.next;
    }
    return head.next;
  }
}
