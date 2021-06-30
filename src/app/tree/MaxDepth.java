package app.tree;
/**
 *  给定一个二叉树，找出其最大深度。

二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 */
public class MaxDepth {
  public int solution(TreeNode root){
    //使用递归的方式
    return root==null?0:Integer.max(solution(root.left), solution(root.right))+1;
  }
}
