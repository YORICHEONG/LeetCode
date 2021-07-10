package higher.treegraph;
 
/**
 * @author YORICHEONG
 * @date 2021-07-08 13:52:12
 * @description 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 */
public class LowestCommonAncestor {
    /**
     * 递归的方法来找到
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 如果当前节点包含想要找的任意的一个节点就可以直接返回当前节点
        if(root == null || root == p || root == q) {
            return root;
        } 
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 然后来进行条件的判断

        // 如果两边都没有找到这个值就直接返回null
        if(left == null && right == null) {
            return null;
        }
        // 如果当前节点的左节点没有,就直接返回右节点
        if(left == null) {
            return right;
        }

        if(right == null) {
            return left;
        }
        // 如果两边都不为空就直接返回
        return root;
    }
}
/**
 * TreeNode struct
 */
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.val = val;
    }
}
