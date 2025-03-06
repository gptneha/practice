# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def hasPathSum(self, root: Optional[TreeNode], targetSum: int) -> bool:
        return self.dfs(root, targetSum,0)
        
    
    def dfs(self, root:Optional[TreeNode], targetSum:int, pathSum:int) -> bool:
        if root is None:
            return False
        if pathSum + root.val == targetSum and root.left is None and root.right is None:
            return True
        
        return self.dfs(root.left, targetSum, pathSum + root.val) or self.dfs(root.right, targetSum, pathSum + root.val)
        
