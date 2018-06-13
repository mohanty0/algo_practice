package com.company.sorting;

import java.util.Random;

public class SelectionSort {


    public static void sort(Integer[] a) {
        int length = a.length;

        for (int i=0; i<length; i++) {
            int minIndex = i;
            for (int j=i+1; j<length; j++) {
                if (a[j] < (a[minIndex])) {
                    minIndex = j;
                }
            }
            int temp = a[minIndex];
            a[minIndex] = a[i];
            a[i] = temp;
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
        Integer[] nums = generateArray(10,20);
        printArray(nums);
        sort(nums);
        printArray(nums);
        System.out.println("Array is sorted: " + isSorted(nums)) ;
    }

}
