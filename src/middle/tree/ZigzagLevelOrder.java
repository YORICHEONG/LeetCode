package middle.tree;


import java.util.*;


public class ZigzagLevelOrder {
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    if(root==null){
      return result;
    }
    Stack<TreeNode> stack = new Stack<TreeNode>();
    stack.push(root);
    boolean flag = true;
    while(!stack.isEmpty()){
      int length = stack.size();
      ArrayList<Integer> list = new ArrayList<Integer>();
      List<TreeNode> set = new ArrayList<TreeNode>();
      for(int i = 0; i<length; i++){
        TreeNode temp = stack.pop();
        list.add(temp.val);
        if(flag){
          if(temp.left!=null){
            set.add(temp.left);
          }
          if(temp.right!=null){
            set.add(temp.right);
          }
        }else{
          if(temp.right!=null){
            set.add(temp.right);
          }
          if(temp.left!=null){
            set.add(temp.left);
          }
        }
      }
      for(int i = 0;i<set.size(); i++){
        stack.push(set.get(i));
      }
      flag = !flag;
      result.add(list);
    }
    return result;
  }
}
