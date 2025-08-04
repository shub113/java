import java.util.*;

//Minimum number of deletions to make a string palindrome
//Given a string of size ‘n’. The task is to remove or delete minimum number of characters from the string so that the resultant string is palindrome.
// MODIFY - Also print deleted characters and their position.

// SOLUTION -> reverse string and find LCS. This will provide LPS and then find the length and compare both string and lps to find the characters and their positions.

class MinimumDeletionToConvertToPallindrome {

    static class DeletionInfo {
        char character;
        int position;

        DeletionInfo(char character, int position) {
            this.character = character;
            this.position = position;
        }

        public String toString() {
            return "Delete '" + character + "' at position - " + position;
        }
    }

    private static void deletion(String str, String lps) {
        List<DeletionInfo> list = new ArrayList<>();
        int lpsIndex = 0;
        for (int i = 0; i < str.length(); i++) {
            if (lpsIndex < lps.length() && str.charAt(i) == lps.charAt(lpsIndex)) {
                lpsIndex++;
            } else {
                list.add(new DeletionInfo(str.charAt(i), i));
            }
        }
        for (DeletionInfo item : list) {
            System.out.println(item.toString());
        }
    }

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
        for (int[] row : dp) {
            for (int value : row) {
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

    public static void main(String[] args) throws java.lang.Exception {

        String str = "bbbab";
        String ans = lps(str);
        System.out.println(ans);
        deletion(str, ans);
    }
}