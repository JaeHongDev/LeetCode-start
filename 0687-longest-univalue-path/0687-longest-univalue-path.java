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
    int longest; 
    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return longest;
    }

    int dfs(TreeNode root){
        if(root == null) return 0;
        var left = dfs(root.left);
        var right = dfs(root.right); 

        if(root.left != null && root.left.val == root.val) left += 1; 
        else left = 0;
        
        if(root.right != null && root.right.val == root.val) right += 1;
        else right = 0; 

        longest = Math.max(longest, left+right);
        return Math.max(left,right);
    }
}