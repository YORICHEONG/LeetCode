package middle.tree;

import java.util.*;

public class BuildTree {
  private Map<Integer,Integer> indexMap;
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    int length = preorder.length;
    
    indexMap = new HashMap<Integer,Integer>();

    for(int i = 0; i<length; i++){
      indexMap.put(inorder[i], i);
    }

    return myBuildTree(preorder, inorder, 0, length-1, 0 , length-1);
  }

  private TreeNode myBuildTree(int[] preorder,int[] inorder,int preorder_left,int preorder_right,int inorder_left,int inorder_right){

    if(preorder_left>preorder_right){
      return null;
    }

    int preorder_root = preorder_left;
    int inorder_root = indexMap.get(preorder[preorder_root]);

    TreeNode root = new TreeNode(preorder[preorder_root]);
    
    int size_left_subtree = inorder_root-inorder_left;//获得左子树的节点个数

    root.left = myBuildTree(preorder, inorder, preorder_left+1, preorder_left+size_left_subtree, inorder_left, inorder_root-1);

    root.right = myBuildTree(preorder, inorder, preorder_left+size_left_subtree+1, preorder_right, inorder_root+1, inorder_right);
    return root;
  }
}
