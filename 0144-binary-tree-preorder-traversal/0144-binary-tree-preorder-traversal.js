/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[]}
 */
var preorderTraversal = function(root) {
    const answer =[];
    const dfs = (p) => {
        if(p === null){
            return ; 
        }
        answer.push(p.val);
       
        dfs(p.left)
        dfs(p.right);
    }
    dfs(root)
    return answer;
};