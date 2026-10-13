/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int leftNode=minDepth(root.left);
        int rightNode=minDepth(root.right);
        if (root.left == null || root.right == null) {
            return leftNode + rightNode + 1;
        }
        int minheight=Math.min(leftNode,rightNode)+1;
        return minheight;
    }
}