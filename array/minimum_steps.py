# You are in an infinite 2D grid where you can move in any of the 8 directions :

#  (x,y) to 
#     (x+1, y), 
#     (x - 1, y), 
#     (x, y+1), 
#     (x, y-1), 
#     (x-1, y-1), 
#     (x+1,y+1), 
#     (x-1,y+1), 
#     (x+1,y-1) 
# You are given a sequence of points and the order in which you need to cover the points. Give the minimum number of steps in which you can achieve it. You start from the first point.

#sample input
# Input : [(0, 0), (1, 1), (1, 2)]
# Output : 2

import math
class Solution:
    # @param A : list of integers
    # @param B : list of integers
    # @return an integer
    def coverPoints(self, A, B):
        td = 0
        for i in range(1, len(A)) :
            dist1 = abs(A[i] - A[i-1])
            dist2 = abs(B[i] - B[i-1])
            if dist1==dist2:
                td = td+dist1
                dist1 = 0
                dist2 = 0
            elif dist1>dist2:
                td = td + dist2
                dist1 = dist1 - dist2
                dist2 = 0
            else :
                td = td +  dist1
                dist2 = dist2 - dist1
                dist1 = 0
            td = td + dist1 + dist2
            
        return td  