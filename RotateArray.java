import java.util.*;
import java.lang.*;
import java.io.*;


class RotateArray
{

    // Space -> O(n)
    // Time -> O(n)
    // newPositions = (index + k) % arr.length 
    public static int[] rotateToRight2(int[] arr, int k) {
        int[] rotatedArray = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            rotatedArray[(i + k) % arr.length] = arr[i];
        }
        return rotatedArray;
    }

    // Space -> O(1)
    // Time -> O(n)
    // reverse array
    // reverse 0 to k-1
    // reverse k to array.length
    public static int[] rotateToRight1(int[] arr, int k) {
        int r = k % arr.length; // incase k > arr.length

        //reverse array
        reverse(arr, 0, arr.length - 1);

        // rever 0 to index
        reverse(arr, 0, r - 1);

        // reverse index to arr.length-1
        reverse(arr, r, arr.length - 1);

        return arr;

    }

    public static int[] reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = temp;
        }
        return arr;
    }

    // left rotaion 2 is same as right rotation arr.length - 2
    public static int[] rotateToLeft(int[] arr, int k) {
        int r = k % arr.length;
        int newR = arr.length - r;
        return rotateToRight2(arr, newR);
    }



    public static void main(String[] args) throws java.lang.Exception
    {
        int[] ans = rotateToLeft(new int[] {
            1,
            2,
            3,
            4,
            5,
            6,
            7
        }, 3);
        for (int i: ans) {
            System.out.println(i + ", ");
        }

    }
}