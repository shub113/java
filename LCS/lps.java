import java.util.*;
import java.lang.*;
import java.io.*;

//Given a sequence, find the length of the longest palindromic subsequence in it.

// ANSWER -> The LCS between a string and its reverse will be the longest sequence that appears in the same order in both the original and reversed string. 
// SOLUTION -> reverse string and find LCS


class LongestPanlindromicSubsequence
{

    private static String lps(String str1) {
        if (str1 == null || str1.isEmpty()) {
            return "";
        }
        StringBuilder str2 = new StringBuilder();
        int m = str1.length();

        for (int i = m - 1; i >= 0; i--) {
            str2.append(str1.charAt(i));
        }

        int n = str2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int[] row: dp) {
            for (int value: row) {
                sb.append(value).append(", ");
            }
            sb.append("\n");
        }
        System.out.println(sb);

        StringBuilder ans = new StringBuilder();
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                ans.append(str1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        return ans.reverse().toString();
    }

    public static void main(String[] args) throws java.lang.Exception
    {


        String ans = lps("bbbab");
        System.out.println(ans);
    }
}