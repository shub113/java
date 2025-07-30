import java.util.*;
import java.io.*;

// Time Complexity: O(nW)
// Space Complexity: O(nW)
class Knapsack_01 {
    private static int[][] knapsack(int capacity, int[] w, int[] v) {
        if (w == null || v == null || w.length != v.length || capacity < 0) {
            throw new IllegalArgumentException("Invalid input");
        }
        final int N = w.length;
        int[][] dp = new int[N + 1][capacity + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (w[i - 1] <= j) {
                    dp[i][j] = Math.max(
                            dp[i - 1][j],
                            dp[i - 1][j - w[i - 1]] + v[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp;
    }

    private static List<Integer> getSelectedItems(int[][] matrix, int capacity, int[] weights) {
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        int cap = capacity;

        for (int i = weights.length; i > 0; i--) {
            if (matrix[i - 1][cap] != matrix[i][cap]) {
                list.add(i - 1);
                cap -= weights[i - 1];
            }
        }
        return list;
    }

    private static String printMatrix(int[][] matrix) {
        StringBuilder sb = new StringBuilder();

        for (int[] row : matrix) {
            for (int value : row) {
                sb.append(value).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) throws java.lang.Exception {
        int[] values = new int[] {
                12,
                15,
                30,
                90
        };
        int[] weights = new int[] {
                3,
                5,
                7,
                1
        };
        int capacity = 10;
        int[][] ans = knapsack(capacity, weights, values);

        System.out.println(printMatrix(ans));
        List<Integer> indices = getSelectedItems(ans, capacity, weights);
        System.out.println(indices);
    }
}