import java.util.*;
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix[0].length;
        int n = matrix.length;
        int left = 0;
        int right = m-1;
        int up = 0;
        int down = n-1;
        List<Integer> output = new ArrayList<>();
        if (m >  1 && n==1) {
            for (int i=0; i< m;  i++) {
                output.add(matrix[0][i]);
            }
            return output;
        }
        if (n > 1 && m==1) {
            for (int i=0; i< n;  i++) {
                output.add(matrix[i][0]);
            }
            return output;
        }
        //handle base cases here for n < 2
        while (output.size()<m*n) {
            for (int i =left; i <= right; i++) {
                output.add(matrix[up][i]);
            }
            for (int j = up+1; j <= down; j++) {
                output.add(matrix[j][right]);
            }
            if (up != down) {
                for (int k = right-1; k >= left; k--) {
                    output.add(matrix[down][k]);
                }
            }
            if (left != right) {
                for (int l = down-1; l > up; l--) {
                    output.add(matrix[l][left]);
                }
            }
            left = left + 1;
            right = right - 1;
            up = up + 1;
            down = down - 1;
        }
        return output;
    }
}
