package top100;

import app.tree.TreeNode;

/**
 * @Description 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * @Author YORICHEONG yoricheong@gmail.com precent99@qq.com
 * @Date 2021/10/22 9:55
 * @Tags
 **/
public class PathSum {
    /**
     * @Description: 使用深度遍历的方法来进行查找
     * @Author: YORICHEONG 
     * @Date: 10:02 2021/10/22
     **/
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) {
            return 0;
        }
        int ret = rootSum(root, targetSum);
        ret += rootSum(root.left, targetSum);
        ret += rootSum(root.right, targetSum);
        
        return ret;
    }

    /**
     * @Description: 计算路径之和
     * @Author: YORICHEONG
     * @Date: 10:03 2021/10/22
     **/
    private int rootSum(TreeNode root, int targetSum) {
        int ret = 0;
        if(root == null) {
            return 0;
        }
        int val = root.val;
        if(targetSum == val) {
            ret++;
        }
        ret += rootSum(root.left, targetSum - val);
        ret += rootSum(root.right, targetSum - val);

        return ret;
    }

    class Solution {
        public int pathSum(TreeNode root, int targetSum) {
            if (root == null) {
                return 0;
            }

            int ret = rootSum(root, targetSum);
            ret += pathSum(root.left, targetSum);
            ret += pathSum(root.right, targetSum);
            return ret;
        }

        public int rootSum(TreeNode root, int targetSum) {
            int ret = 0;

            if (root == null) {
                return 0;
            }
            int val = root.val;
            if (val == targetSum) {
                ret++;
            }

            ret += rootSum(root.left, targetSum - val);
            ret += rootSum(root.right, targetSum - val);
            return ret;
        }
    }

}
