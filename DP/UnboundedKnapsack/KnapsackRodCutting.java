package DP.UnboundedKnapsack;

//  Given a rod of length n inches and an array of prices that contains prices of all pieces of size smaller than n. Determine the  maximum value obtainable by cutting up the rod and selling the pieces. 

class KnapsackRodCutting {
    private static int knapsack(int[] prices, int length) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        int[][] dp = new int[n + 1][length + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= length; j++) {
                if (i > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max((prices[i - 1] + dp[i][j - i]), dp[i - 1][j]);
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

        return dp[n][length];
    }

    // Better spcae complexity
    private static int knapsack_2(int[] prices, int length) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int[] dp = new int[length + 1];

        // Build the DP table bottom-up
        for (int i = 1; i <= length; i++) {
            int maxVal = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                maxVal = Math.max(maxVal, prices[j] + dp[i - j - 1]);
            }
            dp[i] = maxVal;
        }

        return dp[length];
    }

    public static void main(String[] args) throws java.lang.Exception {
        int[] prices = {
                1,
                5,
                8,
                9,
                10,
                17,
                17,
                20
        };
        int rodLength = 8;

        int ans = knapsack(prices, rodLength);
        System.out.println(ans);

        int ans2 = knapsack_2(prices, rodLength);
        System.out.println(ans2);
    }
}