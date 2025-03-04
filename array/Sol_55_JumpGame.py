class Solution:
    def canJump(self, nums: List[int]) -> bool:
        """
        - check from the end of array
        - check if second last element can reach to last element or not
        - if yes then check if third last element can reach to second last or not
        - if no then check if third last element can reach to the last element or not
        - if finally first element is helping in reaching to the last then return true or return false
        """
        if len(nums) <= 1:
            return True
        result = False
        lastIndex = len(nums) - 2
        end = len(nums) - 1
        while lastIndex >= 0:
            if nums[lastIndex] >= (end - lastIndex):
                lastIndex = lastIndex - 1
                end = lastIndex + 1
                result = True
            else:
                lastIndex = lastIndex -1
                result = False
        return result