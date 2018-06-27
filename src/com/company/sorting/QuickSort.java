package com.company.sorting;

import java.util.Random;

public class QuickSort {
    public static void sort(Integer[] a, int lo, int hi) {
        if (hi<= lo) return;
        int pi = partition(a ,lo, hi);
        sort(a, lo, pi-1);
        sort(a, pi+1, hi);
    }

    public static int partition(Integer[] a, int lo, int hi) {
        int pivot = a[hi];
        int i = (lo-1); // index of smaller element
        for (int j=lo; j<hi; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            if (a[j] <= pivot)
            {
                i++;

                // swap arr[i] and arr[j]
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = a[i+1];
        a[i+1] = a[hi];
        a[hi] = temp;

        return i+1;
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
        Integer[] nums = generateArray(10,20);
        printArray(nums);
        sort(nums, 0, nums.length-1);
        printArray(nums);
        System.out.println("Array is sorted: " + isSorted(nums)) ;
    }

}
