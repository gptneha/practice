import java.util.*;
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resultArray = new ArrayList<>();
        if (root == null) {
            return resultArray;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> l = new ArrayList<>();
        q.add(root);
        while (q.size() != 0) {
            List<TreeNode> nextLevel = new ArrayList<>();
            List<Integer> levelRes = new ArrayList<>();
            while(q.size()!=0) {
                
                TreeNode n = q.remove();
                levelRes.add(n.val);
                nextLevel.add(n);
            }
            resultArray.add(levelRes);
            for (TreeNode node: nextLevel) {
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
        }
        return resultArray;
    }
}
