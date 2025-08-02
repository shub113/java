package DP.Knapsack;

import java.util.*;

class EqualSumPartition {
    // Time -> O(size * sum)
    // Space -> O(size * sum)
    private static void partition(int[] num) {
        int total = 0;
        for (int i : num) {
            total += i;
        }

        if (total % 2 != 0) {
            System.out.println("Total sum is odd. Not possible");
            return;
        }

        int sum = total / 2;
        int size = num.length;
        boolean[][] dp = new boolean[size + 1][sum + 1];

        dp[0][0] = true;

        for (int i = 1; i <= size; i++) {
            for (int j = 0; j <= sum; j++) {
                if (num[i - 1] > j) {
                    // Cannot include nums[i-1], take the value from above
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // Either include nums[i-1] or exclude it
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - num[i - 1]];
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (boolean[] row : dp) {
            for (boolean value : row) {
                sb.append(value).append(", ");
            }
            sb.append("\n");
        }
        System.out.println(sb);

        List<Integer> list = new ArrayList<>();
        // backtracking for indices
        int i = size;
        int j = sum;
        while (i > 0 && j > 0) {
            if (dp[i][j] && !dp[i - 1][j]) {
                list.add(i - 1);
                j -= num[i - 1];
            }
            i--;
        }
        System.out.println("Indices - " + list);
    }

    public static void main(String[] args) throws java.lang.Exception {
        partition(new int[] {
                1,
                5,
                11,
                5
        });
    }
}