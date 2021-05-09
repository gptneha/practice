/* Author : Neha 
Aim is to implement below operation of a heap - 
1. Build a max heap using array
2. insert an element in the max-heap
3. extract max element
4. heap sort
5. build a min heap 
6. extract min element */
import java.util.Arrays;
import java.io.*;
import java.lang.Math;

public class Heap {
    public static void main(String[] args) {
        int[] exArray = {1,2,4,5,6,3,8,7,9};
        buildHeap(exArray);
    }

    /* 1. Build a max heap using array 
    Iterate array through n/2 to 0 
    call max heapify for each parent as leaf nodes are 
    already following max-heap structure as they dont have any children
    */

    /*Max heapify  (a, i)
    compare a[i] with its two children
    1. if it is greater than both the children then do nothing
    2. compare it with both the children and swap with greatest one
    */

    public static void buildHeap(int[] a) {
        if (a.length == 0) {
            return ;
        }
        int maxIndextoStart = (int)Math.floor((a.length/2) - 1);
        System.out.println(a.length);
        System.out.println(maxIndextoStart);
        for (int i = maxIndextoStart  ; i >= 0  ; i--) {
            System.out.println("Calling max-heapify for " + a[i]);
            a = maxHeapify(a, i);
            for (int j = 0; j < a.length ; j ++) {
                System.out.print(a[j]);
                System.out.print(" , ");
            }
            System.out.println("");
        }
    }

    public static int[] maxHeapify(int[] a, int i) {
        int leftChild = 2*i + 1 ;
        int rightChild = 2*i +2;
        int isCheckForRight = 1;
        //if left child does not exist, then right also will not exist and safe to re
        if (a.length -1  < leftChild+1) {
            return a;
        }
        
        if (a.length - 1 < rightChild) {
            isCheckForRight = 0;
        }

        System.out.println("iisCheckForRight " + isCheckForRight);
        if (a[i] >= a[leftChild] && ((isCheckForRight == 1) && (a[i] >= a[rightChild]))) {
            System.out.println("No need to maxheapify , already in correct place 1");
            return a;
        }
        
        if (isCheckForRight == 0 && (a[i] >= a[leftChild])) {
            System.out.println("No need to maxheapify , already in correct place 2");
            return a;
        }

        int maxIndex = leftChild;
        if ((isCheckForRight == 1) && (a[rightChild] > a[leftChild])) { 
            System.out.println("Swap with right child  " + a[leftChild] + " " + a[rightChild]);
            maxIndex = rightChild;
        } else {
            System.out.println("Swap with left child  " + a[leftChild] + " " + a[rightChild]);
        }
        //swap with parent
        System.out.println("Swaping elements Index1 " + i + " index2 " + maxIndex);
        int temp = a[i];
        a[i] = a[maxIndex];
        a[maxIndex] = temp;
        a = maxHeapify(a, maxIndex);
        return a;
    }

    // public static extractMax(int[] a) {

    // }
}