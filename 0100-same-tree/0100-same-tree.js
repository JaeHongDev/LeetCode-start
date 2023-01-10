function TreeNode(val, left, right) {
    this.val = (val===undefined ? 0 : val)
    this.left = (left===undefined ? null : left)
    this.right = (right===undefined ? null : right)
}
/**
 * @param {TreeNode} p
 * @param {TreeNode} q
 * @return {boolean}
 */
var isSameTree = function(p, q) {
    let answer = true;

    const hasNull = (a, b) => (a !== null && b === null) || (a === null && b !==null)
    const hasNullBoth = (a,b) => (a === null && b === null)
    const dfs = (p, q) => {
        if(answer === false || hasNullBoth(p,q)){
            return ; 
        }
        
        if(hasNull(p,q) || p.val !== q.val){
           answer = false;
            return ;
        }
        dfs(p.left,q.left);
        dfs(p.right,q.right);
    }
    dfs(p,q);
    return answer;
};