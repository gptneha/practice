/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;
// Given an unsorted array A of size N of non-negative integers, find a continuous sub-array which adds to a given number S.

// Input:
// The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consists of two lines. The first line of each test case is N and S, where N is the size of array and S is the sum. The second line of each test case contains N space separated integers denoting the array elements.

// Output:
// For each testcase, in a new line, print the starting and ending positions(1 indexing) of first such occuring subarray from the left if sum equals to subarray, else print -1.

// Constraints:
// 1 <= T <= 100
// 1 <= N <= 10 [power] 7
// 1 <= Ai <= 10 [power] 10

// Example:
// Input:
// 2
// 5 12
// 1 2 3 7 5
// 10 15
// 1 2 3 4 5 6 7 8 9 10
// Output:
// 2 4
// 1 5

// Explanation : 
// Testcase1: sum of elements from 2nd position to 4th position is 12
// Testcase2: sum of elements from 1st position to 5th position is 15
class SumOfSubArray {
    public static void main (String[] args) {
		//code
        Scanner sc = new Scanner(System. in);
        int t = sc.nextInt();
        for (int j = 0 ; j < t ; j = j+1) {
            int n = sc.nextInt();
            Long gs = sc.nextLong();
            Long a[] = new Long[n];
            Long sum = 0l;
            int li=0;
            int ri=0;
            for (int k = 0; k < n ; k = k+1) {
                a[k] = sc.nextLong();
            }
            int count = 0;
            int ans = 0;
            for (int k = 0; k < n; k = k+1) {
                sum = sum + a[k];
                ri = ri + 1;
                if (sum.equals(gs)) {
                    count = count + 1;
                    ans = 1;
                    System.out.println((li+1) + " " + ri);
                    break;
                } else if (sum > gs) {
                    while (sum > gs && li < ri) {
                        sum = sum - a[li];
                        li = li + 1;
                        if (sum.equals(gs)) {
                            count = count + 1 ;
                            ans = 1;
                            System.out.println((li+1) + " " + ri);
                        }
                    }
                    if (count == 1) {
                        count = 0;
                        break;
                    }
                }
            }
            if (ans == 0) {
                System.out.println("-1");
            } else {
                ans = 0;
            }
        }
	}
}