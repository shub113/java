import java.util.*;
import java.lang.*;
import java.io.*;

// Given an array of integers (positive and/or negative),
// find the maximum sum of any contiguous subarray

//Kadane's Algorithm is an efficient O(n) solution to find the maximum sum subarray in a given array of numbers (including negative numbers).
//It works by dynamically tracking the best possible subarray sum ending at each position in the array.

class MaximumSumSubarray
{

    // LOGIC FOR KADANE's ALGO
    //If adding the current number improves current_max, we extend the subarray.

    //If the current number itself is better than the extended subarray, we start fresh from this number.

    //This ensures we always consider the optimal subarray up to the current index.
    // Time -> O(n)
    // Space -> O(1)
    private static void maxSum1_kadane(int[] arr) {
        int globalMax = arr[0];
        int currentMax = arr[0];
        int start = 0;
        int end = 0;
        int tempStart = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > (currentMax + arr[i])) {
                // start new subarray
                tempStart = i;
                currentMax = arr[i];
            } else {
                // extend existing subarray
                currentMax += arr[i];
            }

            // updated globalMax and start if currentMax is greater
            if (currentMax > globalMax) {
                start = tempStart;
                globalMax = currentMax;
                end = i;
            }
        }
        System.out.println("start - " + start + ", end - " + end + ", total - " + globalMax + ", currentMax - " + currentMax);
    }

    // Time -> O(n^2)
    // Space -> O(1)
    private static void maxSum2(int[] arr) {
        int start = 0;
        int end = 0;
        int max_global = arr[0];
        int[] ans = new int[3];

        for (int i = 0; i < arr.length - 1; i++) {
            int currentSum = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                currentSum += arr[j];
                if (currentSum > max_global) {
                    start = i;
                    end = j;
                    max_global = currentSum;
                }
            }
        }

        System.out.println("start - " + start + ", end - " + end + ", total - " + max_global);
    }
    public static void main(String[] args) throws java.lang.Exception
    {
        // your code goes here
        maxSum2(new int[] {
            -2, 1, -3, 4, -1, 2, 1, -5, 4
        });

        maxSum1_kadane(new int[] {
            110,
            -10,
            95,
            2,
            -1000
        });
    }
}