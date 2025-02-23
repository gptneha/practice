import java.util.*;
import java.io.*;
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            for (int i=0; i< n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }
        if (n == 0) {
            return;
        }
        
        int r1 = m-1;
        int r2 = n-1;
        int index = m+n-1;
        while (r1 >= 0 && r2 >= 0) {
         
            if (nums1[r1] >= nums2[r2]) {
                nums1[index] = nums1[r1];
                //System.out.println(nums1[index]);
                index = index - 1;
                r1 = r1 -1;
            } else if (nums2[r2] > nums1[r1]) {
                nums1[index] = nums2[r2];
                index = index - 1;
                //System.out.println(nums1[index]);
                r2 = r2 -1;
            }
            
            if (r1 < 0 || r2 < 0) {
                break;
            }
        }
        if (r1 >= 0) {
            while (r1 >=0) {
                //System.out.println("in 1");
                nums1[index] = nums1[r1];
                r1 = r1-1;
                index = index - 1;
            }
        }
        //System.out.println("in 3");
        if (r2 >= 0) {
            while (r2 >=0) {
                //System.out.println("in 2");
                nums1[index] = nums2[r2];
                r2 = r2-1;
                index = index - 1;
            }
        }
        
    }
}
