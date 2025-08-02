class LCSubsequence {
    // Time -> O(n*m)
    // Space -> O(n*m)
    static int[][] matrix;

    private static String lCS(String str1, String str2) {
        if (str1.isEmpty() || str1 == null || str2.isEmpty() || str2 == null) {
            throw new IllegalArgumentException("Empty input");
        }

        int m = str1.length();
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

        // construct common string from table
        int index = dp[m][n];
        char[] common = new char[index--];
        int i = m;
        int j = n;

        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                common[index--] = str1.charAt(i - 1);
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        return new String(common);
    }

    private static String LCSRecursion(String str1, String str2) {
        if (str1.isEmpty() || str1 == null || str2.isEmpty() || str2 == null) {
            throw new IllegalArgumentException("Empty input");
        }
        int m = str1.length();
        int n = str2.length();
        matrix = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                matrix[i][j] = -1;
            }
        }

        int value = lcsHelper(str1, str2, m, n);
        StringBuilder sb = new StringBuilder();
        for (int[] row : matrix) {
            for (int val : row) {
                sb.append(val).append(", ");
            }
            sb.append("\n");
        }
        System.out.println(sb);

        // construct common string from table
        int index = value;
        char[] common = new char[index--];
        int i = m;
        int j = n;
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                common[index--] = str1.charAt(i - 1);
                i--;
                j--;
            } else if (matrix[i - 1][j] > matrix[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        return new String(common);
    }

    private static int lcsHelper(String str1, String str2, int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }

        if (matrix[m][n] != -1) {
            return matrix[m][n];
        }

        if (str1.charAt(m - 1) == str2.charAt(n - 1)) {
            matrix[m][n] = 1 + lcsHelper(str1, str2, m - 1, n - 1);
        } else {
            matrix[m][n] = Math.max(lcsHelper(str1, str2, m - 1, n), lcsHelper(str1, str2, m, n - 1));
        }
        return matrix[m][n];

    }

    public static void main(String[] args) throws java.lang.Exception {
        String ans = lCS("ajklmq", "bjklmcq");
        System.out.println(ans);

        String ans2 = LCSRecursion("ajklmq", "bjklmcq");
        System.out.println(ans2);
    }
}