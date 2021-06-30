package Begin.link;
/**
 * 
 * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点。传入函数的唯一参数为 要被删除的节点 。

 

  现有一个链表 -- head = [4,5,1,9]，它可以表示为

 */
public class DeleteNode {
  public void solution(ListNode node){
    //将要删除的节点和赋值为下一个节点，然后将下一个节点删除
    node.val = node.next.val;
    node.next = node.next.next;
  }
}
