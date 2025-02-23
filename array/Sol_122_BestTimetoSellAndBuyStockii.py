class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        """
        create an array with difference in the orginal array and store difference between the consecutive elements
        maximum profit will be the sum of the positive element in the array
        
        """

        diff = []
        for i in range(1, len(prices)):
            diff.append(prices[i]-prices[i-1])
        
        result = 0
        for i in range(0, len(diff)):
            if diff[i] > 0:
                result = result + diff[i]
        return result
