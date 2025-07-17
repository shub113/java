import java.util.*;
import java.lang.*;
import java.io.*;


class TwoStack
{

    int[] arr;
    int top1;
    int top2;

    public TwoStack(int size) {
        arr = new int[size];
        this.top1 = 0;
        this.top2 = size - 1;
    }

    public void push1(int ele) throws Exception {
        if (top1 > top2) {
            throw new Exception("Stack Overflow");
        }
        arr[top1++] = ele;
    }

    public void push2(int ele) throws Exception {
        if (top1 > top2) {
            throw new Exception("Stack Overflow");
        }
        arr[top2--] = ele;
    }

    public void pop1() throws Exception {
        top1--;
        if (top1 == 0) {
            throw new Exception("Stack Underflow");
        }
        arr[top1] = 0;
    }

    public void pop2() throws Exception {
        top2++;
        if (top2 == arr.length) {
            throw new Exception("Stack Underflow");
        }
        arr[top2] = 0;
    }

    public String toString() {
        String str = new String();
        for (int i: arr) {
            str = str + i + ", ";
        }
        return str;
    }

    public static void main(String[] args) throws java.lang.Exception
    {
        TwoStack ts = new TwoStack(9);
        ts.push1(3);
        ts.push1(5);
        ts.push1(1);
        ts.push1(13);
        ts.push1(14);

        ts.push2(10);
        ts.push2(11);
        ts.push2(8);
        ts.push2(7);
        ts.pop2();
        ts.pop2();
        ts.pop2();
        ts.pop2();


        System.out.println(ts);

    }
}