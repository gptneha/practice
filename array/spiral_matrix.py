class Solution:
    # @param A : tuple of list of integers
    # @return a list of integers
    def spiralOrder(self, A):
        l = 0
        r = len(A[0]) - 1
        t = 0
        b = len(A) - 1
        d = 0
        ret = []
        while (l<=r) and (t<=b):
            if (d==0):
                for i in range(l, r+1):
                    ret.append(A[t][i])
                t = t+1
            elif (d==1):
                for i in range(t, b+1):
                    ret.append(A[i][r])
                r = r-1
            elif (d==2):
                for i in range(r, l-1, -1):
                    ret.append(A[b][i])
                b = b-1
            elif (d==3):
                for i in range(b, t-1, -1):
                    ret.append(A[i][l])
                l = l+1
            d = (d+1)%4
        #print ret
        return ret
