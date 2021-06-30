package middle.tree;
import java.util.*;

public class InorderTraversal {
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<Integer>();
    mid(root,result);
    return result;
  }

  public void mid(TreeNode root,List<Integer> list){
    if(root==null){
      return;
    }
    mid(root.left,list);
    list.add(root.val);
    mid(root.right,list);
  }
}
