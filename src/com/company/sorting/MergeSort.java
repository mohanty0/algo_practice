package com.company.sorting;

import java.util.Random;

public class MergeSort {
    public static void sort(Integer[] a, int lo, int hi) {
        if (lo < hi) {
            int mi = (hi+lo)/2;
            /*Split array into halfs*/
            sort(a,lo, mi);
            sort(a, mi+1, hi);
            /*Merge pieces back together*/
            merge(a, lo, mi, hi);
        }
    }

    public static void merge(Integer[] a, int lo, int mi, int hi ) {

        int leftSize = (mi-lo)+1;
        int rightSize = (hi-mi);
        /*scratch arrays*/
        Integer[] left = new Integer[leftSize];
        Integer[] right = new Integer[rightSize];

        for (int i=0; i<leftSize; i++) {
            left[i] = a[lo+i];
        }
        for (int i=0; i<rightSize; i++) {
            right[i] = a[mi+i+1];
        }

        int i=0, j=0, k=lo;
        while (i<leftSize && j<rightSize) {
            if (left[i] <= right[j]) {
                a[k] = left[i];
                i++;
            }
            else {
                a[k] = right[j];
                j++;
            }
            k++;
        }
        while (i<leftSize) {
            a[k] = left[i];
            i++;
            k++;
        }
        while (j<rightSize) {
            a[k] = right[j];
            j++;
            k++;
        }
    }


    public static void printArray(Integer a[]) {
        System.out.println();
        for (Integer i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static boolean isSorted(Integer a[]) {
        for (int i=0; i<a.length-1;i++) {
            if (a[i] > a[i+1])
                return false;
        }
        return true;
    }

    public static Integer[] generateArray(int size, int bound) {
        Integer[] arr = new Integer[size];
        Random rand  = new Random();
        for (int i =0; i < arr.length; i++) {
            arr[i] = rand.nextInt(bound);
        }

        return arr;
    }

    public static void main(String[] args) {
        MergeSort sort = new MergeSort();
        Integer[] nums = generateArray(1000,20);
        printArray(nums);
        sort(nums, 0, nums.length-1);
        printArray(nums);
        System.out.println("Array is sorted: " +  isSorted(nums)) ;
    }
}
