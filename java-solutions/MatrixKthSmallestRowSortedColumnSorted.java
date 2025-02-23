import java.util.*;
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix == null || matrix.length == 0) {
           return -1;
        }
        PriorityQueue<Integer> pqueue = new PriorityQueue<>((a,b) -> (b-a));
        int count = 0;
        for (int i = 0; i< matrix.length; i++) {
            for (int j=0; j< matrix[0].length; j++) {
                count = count+ 1;
                pqueue.offer(matrix[i][j]);
                if (count > k) {
                    pqueue.poll();
                }
            }
        }
        return pqueue.peek();
        
    }

}

