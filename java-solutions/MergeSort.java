import java.util.*;

public class MergeSort {

    public static void main(String[] args) {

        //divide the array into 2 until it left and right are equal
        //then start merging the array in sorted order

        List<Integer> a = Arrays.asList(8,6,8,7,4,3,1);
        //System.out.println(a.size()-1);
        mergeSort(a, 0, a.size()-1);
//        for (int i = 0; i < a.size(); i++) {
//            System.out.println(a.get(i));
//        }

    }

    public static void mergeSort(List<Integer> a, int left, int right) {
        //System.out.println("in mergesot");
        if (left >= right) {
            return;
        }

        int mid = left + (right - left)/2;
        //System.out.println("middle"+ mid);
        mergeSort(a, left, mid);
        mergeSort(a, mid+1, right);
        merge(a, left, mid, right);
    }

    public static void merge(List<Integer> a, int left, int mid, int right) {
        if (left == mid || mid == right) {
            return;
        }
        List<Integer> leftA = new ArrayList<>();
        List<Integer> rightA = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for (int i = left; i<=mid ; i++) {
            leftA.add(a.get(i));
        }

        for (int i = mid+1; i<=right ; i++) {
            rightA.add(a.get(i));
        }

        int i = 0;
        int j = 0;

        while (i < leftA.size() && j < rightA.size()) {
            int l = leftA.get(i);
            int r = rightA.get(j);
            if (l < r) {
                temp.add(l);
                i++;
            } else if (r <= l) {
                temp.add(r);
                j++;
            }
        }

        while (i < leftA.size()) {
            temp.add(leftA.get(i));
            i++;
        }

        while (j < rightA.size()) {
            temp.add(rightA.get(j));
            j++;
        }
        for (int k = 0; k < temp.size(); k++) {
            System.out.print(temp.get(k));
            System.out.print(" ");
        }
        System.out.print("\n");
        int m = 0;
        for (int k = left; k <= right; k++) {
            a.set(k, temp.get(m));
            m++;
        }
    }


}
