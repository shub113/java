// Given two strings str1 and str2, find the shortest string that has both str1 and str2 as subsequences.

class SCSupersequence {
    private static String SuperSequence(String str1, String str2) {
        if (str1.isEmpty() || str1 == null || str2.isEmpty() || str2 == null) {
            throw new IllegalArgumentException("Empty string");
        }

        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m + 1][n + 1];

        // lcs table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        StringBuilder s = new StringBuilder();

        for (int[] row : dp) {
            for (int value : row) {
                s.append(value).append(", ");
            }
            s.append("\n");
        }
        System.out.println(s);

        // construct string
        StringBuilder sb = new StringBuilder();
        int i = m, j = n;

        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                sb.append(str1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                sb.append(str1.charAt(i - 1));
                i--;
            } else {
                sb.append(str2.charAt(j - 1));
                j--;
            }
        }

        while (i > 0) {
            sb.append(str1.charAt(i - 1));
            i--;
        }
        while (j > 0) {
            sb.append(str2.charAt(j - 1));
            j--;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) throws java.lang.Exception {
        String ans = SuperSequence("abcmno", "xyzabc");
        System.out.println(ans);
    }
}