import java.util.*;
import java.io.*;

class LCSubstring {
    // Time -> O(n*m)
    // Space -> O(n*m)
    private static String LCS(String str1, String str2) {
        if (str1.isEmpty() || str1 == null || str2.isEmpty() || str2 == null) {
            return "";
        }

        int n = str1.length();
        int m = str2.length();
        int maxLength = 0;
        int end = 0;

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > maxLength) {
                        maxLength = dp[i][j];
                        end = i - 1;
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        if (maxLength == 0)
            return "";
        return str1.substring(end - maxLength + 1, end + 1);
    }

    public static void main(String[] args) throws java.lang.Exception {
        String ans = LCS("ajklmqpoiuytrewq", "bjklmcpoiuytrewq");
        System.out.println(ans);

    }
}