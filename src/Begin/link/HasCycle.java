package Begin.link;
import java.util.Set;
import java.util.HashSet;
/**
 * 给定一个链表，判断链表中是否有环。

   如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。

   如果链表中存在环，则返回 true 。 否则，返回 false 

 */
public class HasCycle {
  /**
   * 使用快慢指针来实现
   * @param head
   * @return
   */
  public boolean solution_01(ListNode head){
    if(head==null){
      return false;
    }
    //首先定义两个指针
    ListNode fast = head;
    ListNode slow = head;
    //然后快慢指针的移动的速度不一致
    while(fast!=null&&fast.next!=null){
      slow = slow.next;
      fast = fast.next.next;

      if(slow==fast){
        return true;
      }
    }
    return false;
  }
  /**
   * 使用一个去重判断来判断是否有节点可以
   * @param head
   * @return
   */
  public boolean solution_02(ListNode head){
    Set<ListNode> set = new HashSet<>();
    while(head!=null){
      if(set.contains(head)){
        return true;
      }
      set.add(head);
      head = head.next;
    }
    return false;
  }
}
