package top100;

import app.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @description: 二叉树的层次遍历
 * @author YORICHEONG
 * @date 2021/9/10 11:02
 * @version 1.0
 */
public class LevelOrder {
    
    /**
     * @param: root
     * @description : 层序遍历
     * @return : java.util.List<java.util.List<java.lang.Integer>>
     * @author : YORICHEONG
     * @date : 2021/9/10
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            List<TreeNode> nextNodeList = new ArrayList<>();
            for(TreeNode node : queue) {
                list.add(node.val);
                if(null != node.left) {
                    nextNodeList.add(node.left);
                }
                if(null != node.right) {
                    nextNodeList.add(node.right);
                }
            }
            ans.add(list);
            queue.clear();
            queue.addAll(nextNodeList);
        }
        return ans;
    }
}
