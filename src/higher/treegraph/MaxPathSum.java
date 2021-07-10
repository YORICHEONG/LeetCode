package higher.treegraph;

/**
 * @author YORICHEONG
 * @date 2021-07-08 14:16:34
 * @description 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。
 * 同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含    一个 节点，且不一定经过根节点。
 */
public class MaxPathSum {

    private int maxSum = Integer.MIN_VALUE;

    private int maxGain(TreeNode node) {
        if(node == null) {
            return 0;
        }
        
        int leftGain = Math.max(maxGain(node.left),0);
        int rightGain = Math.max(maxGain(node.right),0);

        int pathSum = leftGain + rightGain+node.val;

        maxSum = Math.max(maxSum, pathSum);

        return node.val + Math.max(leftGain, rightGain);
    }

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }
}
