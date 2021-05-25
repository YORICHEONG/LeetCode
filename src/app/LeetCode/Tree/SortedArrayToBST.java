package app.LeetCode.Tree;
/**
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。

高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。


 */
public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0){
            return null;
        }
        return solution(nums,0,nums.length-1);
    }
    public TreeNode solution(int[] nums,int start,int end){
        if(start>end){
            return null;
        }
        int mid = (start+end)>>1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = solution(nums,start,mid-1);
        root.right = solution(nums,mid+1,end);
        return root;
    }
}
