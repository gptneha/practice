import java.util.*;
public class QuickSort {
    public static void main(String[] args) {
        //define array
        //quick sort method - a, l, r
        //partitionAndSort - a, l, r -> return -> parition index
        int[] a = new int[]{8,6,8,7,4,3,1};
        quickSort(a, 0, a.length-1);
        for (int i=0; i< a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public static void quickSort(int[] a, int l, int r) {
        //System.out.println(l);
        if (l < r) {
            int p = partitionAndArrange(a, l, r);
            quickSort(a, l, p-1);
            quickSort(a, p+1, r);
        }
        return;
    }

    private static int partitionAndArrange(int[] a, int l, int r) {
        if (l==r) {
            return l;
        }

        int p = r;
        int pivot = a[p];
        int left = l;
        int right = r;
        while (left <= right) {
            if (a[left] > pivot) {
                int temp = a[right];
                a[right] = a[left];
                a[left] = temp;
                right--;
            } else {
                left++;
            }
        }
        a[left] = pivot;
        return left;
    }

}