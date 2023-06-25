import math

class Solution(object):

    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        return self.binSearch(nums, target, 0, len(nums)-1)

    def binSearch(self,  nums, target, start, end):
        print("Neha")
        if (start >= end):
            if (nums[start] == target):
                return start
            else:
                return -1
        mid = int(math.floor(((end - start)/2)+start))
        print("Neha")
        print(mid)
        if (nums[mid] == target):
            return mid
        elif nums[mid] > target:
            return self.binSearch(nums, target, start, mid)
        elif nums[mid] < target:
            return self.binSearch(nums, target, mid+1, end)


s = Solution()
print(s.search([1,2,3,4],2))

