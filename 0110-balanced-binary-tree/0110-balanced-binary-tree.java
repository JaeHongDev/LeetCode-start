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
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        return ((int) Math.abs(dfs(root.left) - dfs(root.right))) <= 1;
    } 

    int dfs(TreeNode root){
        if(root == null) return 0; 
        return Math.max(dfs(root.left), dfs(root.right)) + 1;
    }
}