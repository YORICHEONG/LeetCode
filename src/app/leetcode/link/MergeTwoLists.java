package app.leetcode.link;

public class MergeTwoLists {
  public ListNode solution(ListNode l1,ListNode l2){
    //首先是为空的判断
    if(l1==null){
      return l2;
    }
    if(l2==null){
      return l1;
    }
    ListNode pre = new ListNode(0);
    ListNode cur = pre;
    while(l1!=null&&l2!=null){
      //谁小就将谁的节点放入到新的节点中
      if(l1.val<l2.val){
        cur.next = l1;
        l1 = l1.next;
      }else{
        cur.next = l2;
        l2 = l2.next;
      }
      cur = cur.next;
    }   
    cur.next = l1==null?l2:l1;
    return pre.next;
  }
}
