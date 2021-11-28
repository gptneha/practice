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
    public List<Integer> rightSideView(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();  
        if (root == null) {
            return new ArrayList<>();
        }
        return levelOrderTraversal(root, res);
        
    }
    
    public List<Integer> levelOrderTraversal(TreeNode root, List<List<Integer>> res) {
        List<Integer> output = new ArrayList<>();
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while (q.size()!=0) {
            List<TreeNode> currLevel = new ArrayList<>();
            List<Integer> values = new ArrayList<>();
            while(q.size()!= 0) {
                TreeNode node = q.remove();
                currLevel.add(node);
                values.add(node.val);
            }
            res.add(values);
            for (TreeNode t : currLevel) {
                if (t.left != null) {
                    q.add(t.left);
                }
                if (t.right != null) {
                    q.add(t.right);
                }
            }
            
        }
        
        for (List<Integer> nodes : res) {
            int size = nodes.size();
            output.add(nodes.get(size-1));
        }
        return output;
    }
    
    public List<Integer> rightView(TreeNode root, List<Integer> res) {
        
        if (root == null) {
            return res;
        }
        res.add(root.val);
        if (root.right == null) {
            if (root.left != null) {
                rightView(root.left, res);
            }
        } else {
            rightView(root.right, res);
        }
        return res;   
    }
}
