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
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //concept is to tak max of (dia of left node , dia of right node, dia of self)
        //dia of self = lefthight + right height +1 ;
        int leftDia = diameterOfBinaryTree(root.left);
        int rightDia = diameterOfBinaryTree(root.right);
        int selfDia = height(root.left) + height(root.right);
        
        return max(leftDia, max(rightDia,selfDia));
    }
    
    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + max(height(root.left), height(root.right));
    }
    public int max(int a, int b) {
        if (a > b) {
            return a;
        } else {return b;}
    }
}
