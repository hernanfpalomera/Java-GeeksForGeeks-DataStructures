package com.geeksforgeeks.dataStructures.arrays;


// Java program to illustrate creating an array
// of integers,  puts some values in the array,
// and prints each value to standard output.

public class GFG5 {

    public static void main(String[] args)
    {
        int[] arr = new int[2];
        arr[0] = 10;
        arr[1] = 20;

        for (int i = 0; i < arr.length; i++)
            System.out.println(arr[i]);
    }

}

