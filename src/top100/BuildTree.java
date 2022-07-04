package top100;


import app.tree.TreeNode;

import java.util.List;

/**
 * @description: 给定一棵树的前序遍历 preorder 与中序遍历  inorder。请构造二叉树并返回其根节点。
 * @author YORICHEONG
 * @date 2021/9/10 11:14
 * @version 1.0
 */
public class BuildTree {
    
    /**
     * @param: preorder
     * @param: inorder
     * @description : 使用分而治理的方法来进行
     * @return : app.tree.TreeNode
     * @author : YORICHEONG
     * @date : 2021/9/10
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        return buildTree(preorder, 0, inorder, 0, inorder.length);
    }

    /**
     * @param: preorder
     * @param: headIndex
     * @param: inorder
     * @param: left
     * @param: right
     * @description :
     * @return : app.tree.TreeNode
     * @author : YORICHEONG
     * @date : 2021/9/10
     */
    private TreeNode buildTree(int[] preorder, int headIndex, int[] inorder, int left, int right) {

        return null;
    }

    /**
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {

        return null;
    }
}
