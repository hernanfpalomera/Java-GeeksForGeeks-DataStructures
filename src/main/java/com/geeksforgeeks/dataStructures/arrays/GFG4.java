package com.geeksforgeeks.dataStructures.arrays;


// Java program to illustrate creating an array
// of integers,  puts some values in the array,
// and prints each value to standard output.

public class GFG4 {

    public static void main(String[] args)
    {
        int[] arr = new int[4];
        arr[0] = 10;
        arr[1] = 20;
        arr[2] = 30;
        arr[3] = 40;

        System.out.println(
                "Trying to access element outside the size of array");
        System.out.println(arr[5]);
    }

}

