
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        '''
            need to figure out the totoal numbers of papers let's say x , which has minimum x citations
            sort the array in ascending orders
            check the value of citations[i], result = max(currentResult, min(nums[i], len(nums)-i))
        '''
        if len(citations) <= 0:
            return 0
        citations = sorted(citations)
        result = 0
        for i in range(0, len(citations)):
            result = max(result, min(citations[i], len(citations)-i))
        
        return result
        
