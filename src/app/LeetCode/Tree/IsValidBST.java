package app.LeetCode.Tree;

import javax.swing.plaf.SliderUI;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。

假设一个二叉搜索树具有如下特征：

节点的左子树只包含小于当前节点的数。
节点的右子树只包含大于当前节点的数。
所有左子树和右子树自身必须也是二叉搜索树。

 */
public class IsValidBST {
  /**
   * 使用递归的方式
   * @param root
   * @return
   */
  public boolean solution_01(TreeNode root){
    return solution_01(root, Long.MIN_VALUE, Long.MAX_VALUE);
  }
  public boolean solution_01(TreeNode root,long minVal,long maxVal){
    if(root==null){
      return true;
    }
    if(root.val>=maxVal||root.val<=minVal){
      return false;
    }
    return solution_01(root.left,minVal,root.val)&&solution_01(root.right,root.val,maxVal);
  }
}
