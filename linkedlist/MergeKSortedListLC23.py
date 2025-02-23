# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        result = lists[0]

        for i in range(1, len(lists)):
            newres = sortList(result, lists[i])
            result = newres
        return result

    def mergeTwoList(list1, list2):



        while list1 and list2 not None:
            if (len2.val < len1.val):
                len1 = len1.next
            else:
                # insert element
                temp = len1.next
                len1.next = len2

