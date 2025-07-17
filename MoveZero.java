import java.util.*;
import java.lang.*;
import java.io.*;


class MoveZero
{

    // Space -> O(1)
    // Time -> O(n)
    public static int[] shift(int[] arr) {
       int nonZeroIndex = 0;
       int index =0;
       while(index<arr.length){
           if(arr[index]!= 0){
               arr[nonZeroIndex++] = arr[index];
               arr[index]= 0;
           }
           index++;
       }
       return arr;
    }

   

    public static void main(String[] args) throws java.lang.Exception
    {
       int[] ans = shift(new int[]{0,0,2,0,3,4,0,45});
       for(int i:ans){
           System.out.println(i+", ");
       }

    }
}