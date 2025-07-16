import java.util.*;
import java.lang.*;
import java.io.*;

// Example of dynymic array
class ArrayListExampple
{
	public static void main (String[] args) throws java.lang.Exception
	{
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(10);
        list.add(12);
        
        for(int i: list){
            System.out.println(i);
        }
	}
}
