package middle.Tree;

import java.util.Currency;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.List;

public class Connect {

  public Node connect(Node root) {
    if(root==null){
      return root;
    }
    Queue<Node> queue = new LinkedList<>();
    queue.offer(root);
    while(!queue.isEmpty()){
      int size = queue.size();
      List<Node> list = new ArrayList<Node>();
      for(int i = 0; i<size; i++){
        Node current = queue.poll();
        if(current.left!=null){
          queue.add(current.left);
        }
        if(current.right!=null){
          queue.add(current.right);
        }
        list.add(current);
      }
      if(list.size()==1){
        list.get(0).next=null;
      }else{
        for(int i = 0; i<list.size()-1;i++){
          list.get(i).next = list.get(i+1);
          if(i==list.size()-2){
            list.get(i+1).next = null;
          }
        }
      }
    }
    return root;
  }
}
