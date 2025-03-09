class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        
        if len(nums) == 0:
            return nums
        
        left = [1]*len(nums)
        right = [1]*len(nums)

        leftProduct = 1
        for i in range(1, len(nums)):
            leftProduct = leftProduct*nums[i-1]
            left[i] = leftProduct
        #print(left)
        rightProduct = 1
        for j in range(len(nums)-2,-1, -1):
            #print(j)
            rightProduct = rightProduct*nums[j+1]
            right[j] = rightProduct
        #print(right)
        for i in range(0, len(nums)):
            nums[i] = left[i] * right[i]
        return nums 
