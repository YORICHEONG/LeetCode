package Begin.tree;

public class IsSymmetric {
  //使用递归的方法来进行一个判断
  public boolean solution_01(TreeNode root){
    if(root==null){
      return true;
    }
    return solution_01(root.left, root.right);
  }
  public boolean solution_01(TreeNode left,TreeNode right){
    //同时为空也是一种对称
    if(left==null&&right==null){
      return true;
    }
    if(left==null||right==null||left.val!=right.val){
      return false;
    }
    return solution_01(left.left, left.right)&&solution_01(right.left, right.right);
  }
}
