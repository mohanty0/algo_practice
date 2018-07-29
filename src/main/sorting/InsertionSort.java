package main.sorting;

import java.util.Random;

public class InsertionSort {

    public static void sort(Integer[] a) {
        for (int i=1; i<a.length; i++) {
            int j = i-1;
            int key = a[i];
            while (j!=0 && a[j] > key) {
                a[j+1] = a[j];
                j -= 1;
            }
            a[j] = key;

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
