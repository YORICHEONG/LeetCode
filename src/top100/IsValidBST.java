package top100;

import app.tree.TreeNode;

import java.util.*;

/**
 * @description: 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * 有效 二叉搜索树定义如下：
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * @author YORICHEONG
 * @date 2021/9/10 9:29
 * @version 1.0
 */
public class IsValidBST {

    //===========================Method01================================
    /**
     * @param: root
     * @description : 递归的判断
     * @return : boolean
     * @author : YORICHEONG
     * @date : 2021/9/10
     */
    public boolean isValidBST(TreeNode root) {

        return validBst(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    /**
     * @param: root
     * @param: min
     * @param: max
     * @description :
     * @return : boolean
     * @author : YORICHEONG
     * @date : 2021/9/10
     */
    private boolean validBst(TreeNode root, long min, long max) {
        if(root == null) {
            return true;
        }
        if(root.val <= min || root.val >= max) {
            return false;
        }

        return validBst(root.left, min, root.val) && validBst(root.right, root.val, max);
    }


    //===========================Method 02====================================

    Stack<Integer> queue = new Stack();

    /**
     * @param: root
     * @description : 使用中序遍历方法
     * @return : boolean
     * @author : YORICHEONG
     * @date : 2021/9/10
     */
    public boolean isValidBST2(TreeNode root) {
        if(root == null) {
            return true;
        }
        boolean flag1 = isValidBST2(root.left);
        if(!queue.isEmpty() && queue.peek() >= root.val) {
            return  false;
        }
        queue.add(root.val);
        boolean flag2 = isValidBST2(root.right);

        return flag1 && flag2;
    }

    public static void main(String[] args) {
        TreeNode left = new TreeNode(1, null, null);
        TreeNode right = new TreeNode(3, null, null);
        TreeNode head = new TreeNode(2, left, right);

        System.out.println(new IsValidBST().isValidBST2(head));
    }

}
