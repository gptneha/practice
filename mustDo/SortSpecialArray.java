// Given an array A of size N containing 0s, 1s, and 2s; you need to sort the array in ascending order.

// Input:
// The first line contains an integer 'T' denoting the total number of test cases. Then T testcases follow. Each testcases contains two lines of input. The first line denotes the size of the array N. The second lines contains the elements of the array A separated by spaces.

// Output: 
// For each testcase, print the sorted array.

// Constraints: 
// 1 <= T <= 500
// 1 <= N <= 106
// 0 <= Ai <= 2

// Example:
// Input :
// 2
// 5
// 0 2 1 2 0
// 3
// 0 1 0

// Output:
// 0 0 1 2 2
// 0 0 1

// Explanation:
// Testcase 1: After segragating the 0s, 1s and 2s, we have 0 0 1 2 2 which shown in the output.
import java.util.*;
import java.lang.*;
import java.io.*;

class SortSpecialArray {
	public static void main (String[] args) {
        //code
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
            // taking input of number of testcase 
            int t = Integer.parseInt(br.readLine());

            for (int j = 0 ; j < t ; j = j+1) {
                StringBuffer zero = new StringBuffer();
                StringBuffer one = new StringBuffer();
                StringBuffer two = new StringBuffer(); 
                int n = Integer.parseInt(br.readLine());
                String line = br.readLine(); 
                String[] strs = line.trim().split("\\s+"); 
                for (int k = 0; k< n ; k++) {
                    int num = Integer.valueOf(strs[k]);
                    if (num == 0) {
                        zero.append("0 ");
                    } else if (num == 1) {
                        one.append("1 ");
                    } else if(num == 2) {
                        two.append("2 ");
                    }
                }
                System.out.println(zero.append(one).append(two));
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
	}
}