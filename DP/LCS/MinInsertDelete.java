import java.util.*;

//Given two strings ‘str1’ and ‘str2’ of size m and n respectively. The task is to remove/delete and insert minimum number of characters from/in str1 so as to transform it into str2. It could be possible that the same character needs to be removed/deleted from one point of str1 and inserted to some another point.

// Modified - Also show the character and position at which insertion/deletion occured.

class MinInsertDelete {

    private static String lcs(String str1, String str2) {
        if (str1 == null || str1.isEmpty() || str2 == null || str2.isEmpty()) {
            return "";
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

    static class Operation {
        String type;
        char character;
        int position;

        Operation(String type, char character, int position) {
            this.type = type;
            this.character = character;
            this.position = position;
        }

        @Override
        public String toString() {
            return type + " '" + character + "' at position " + position;
        }
    }

    private static void detailOperation(String str1, String str2) {
        List<Operation> operations = new ArrayList<>();
        String lcs = lcs(str1, str2);

        // Process str1 to find deletions
        int i = 0, j = 0;
        for (char c : str1.toCharArray()) {
            if (j < lcs.length() && c == lcs.charAt(j)) {
                j++;
            } else {
                operations.add(new Operation("Delete", c, i));
            }
            i++;
        }

        // Process str2 to find insertions
        i = 0;
        j = 0;
        for (char c : str2.toCharArray()) {
            if (j < lcs.length() && c == lcs.charAt(j)) {
                j++;
            } else {
                operations.add(new Operation("Insert", c, i));
            }
            i++;
        }

        // Print results
        System.out.println("LCS: " + lcs);
        System.out.println("\nOperations needed:");
        for (Operation op : operations) {
            System.out.println(op);
        }
        System.out.println("\nTotal operations: " + operations.size());

    }

    public static void main(String[] args) throws java.lang.Exception {
        String str1 = "heap";
        String str2 = "pea";

        detailOperation(str1, str2);
    }
}