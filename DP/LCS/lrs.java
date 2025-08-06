// Given a string, print the longest repeating subsequence such that the two subsequence don’t have same string character at same position.
// Example:
// Input: str = "aab"
// Output: "a"
// Solution : LCS of string with itself and with condition i != j

class LongestRepeatingSubsequence {
    private static String lrs(String str1) {
        String str2 = new String(str1);
        int m = str1.length();
        int[][] dp = new int[m + 1][m + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1) && i != j) {
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

        StringBuilder answer = new StringBuilder();
        int i = m;
        int j = m;
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1) && i != j) {
                answer.append(str1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        return answer.reverse().toString();
    }

    public static void main(String[] args) throws java.lang.Exception {
        String input = "aabbc";
        String ans = lrs(input);
        System.out.println(ans);
    }
}