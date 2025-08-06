package DP.Knapsack;

// Knapsack Memoization with recursion.

class RecursiveKnapsack {
    static int[][] memo;

    private static int knapsack(int[] wt, int v[], int W, int n) {
        if (W == 0 || n == 0) {
            return 0;
        }

        if (memo[n - 1][W - 1] != -1) {
            return memo[n][W];
        }

        if (wt[n - 1] > W) {
            memo[n - 1][W - 1] = knapsack(wt, v, W, n - 1);
        } else {
            memo[n - 1][W - 1] = Math.max(v[n - 1] + knapsack(wt, v, W - wt[n - 1], n - 1),
                    knapsack(wt, v, W, n - 1));
        }
        return memo[n - 1][W - 1];
    }

    public static void main(String[] args) throws java.lang.Exception {
        int[] values = {
                60,
                100,
                120
        };
        int[] weights = {
                10,
                20,
                30
        };
        int W = 50;
        int n = values.length;

        memo = new int[n + 1][W + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < W; j++) {
                memo[i][j] = -1;
            }
        }
        int ans = knapsack(weights, values, W, n);
        System.out.println(ans);
    }
}