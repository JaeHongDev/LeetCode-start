/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        var sb = new StringBuilder();
        sb.append(String.valueOf("#," + root.val));
        while(!queue.isEmpty()){
            var node = queue.poll();

            if(node.left != null) {
                queue.add(node.left);
                sb.append("," + node.left.val);
            }
            else sb.append(",#");

            if(node.right != null){
                queue.add(node.right);
                sb.append("," + node.right.val);
            }
            else sb.append(",#");
        }
        return sb.toString();
    }
    

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("")) return null;

        var nodes = data.split(",");
        var root = new TreeNode(Integer.parseInt(nodes[1]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root); 
        var index = 2; 

        while(!queue.isEmpty()){
            var node = queue.poll();

            if(!nodes[index].equals("#")) {
                node.left = new TreeNode(Integer.parseInt(nodes[index]));
                queue.add(node.left);
            }
            index += 1; 

            if(!nodes[index].equals("#")){
                node.right = new TreeNode(Integer.parseInt(nodes[index]));
                queue.add(node.right);
            }
            index += 1; 
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));