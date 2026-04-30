// ============================================================
// Problem    : 3742. Maximum Path Score in a Grid
// Difficulty : Medium
// URL        : https://leetcode.com/problems/maximum-path-score-in-a-grid/
// Language   : Java
// Date       : 2026-04-30
// ============================================================
class Solution {
    public int maxPathScore(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;

        // dp[i][j][c] = max score at (i,j) with cost c
        int[][][] dp = new int[m][n][k + 1];

        // Initialize with -1 (invalid)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int c = 0; c <= k; c++) {
                    dp[i][j][c] = -1;
                }
            }
        }

        // Start cell
        int startCost = (grid[0][0] == 0) ? 0 : 1;
        int startScore = grid[0][0];

        if (startCost <= k) {
            dp[0][0][startCost] = startScore;
        }

        // Fill DP
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int cellCost = (grid[i][j] == 0) ? 0 : 1;
                int cellScore = grid[i][j];

                for (int c = 0; c <= k; c++) {

                    if (i == 0 && j == 0)
                        continue;

                    int prevCost = c - cellCost;
                    if (prevCost < 0)
                        continue;

                    int best = -1;

                    // From top
                    if (i > 0 && dp[i - 1][j][prevCost] != -1) {
                        best = Math.max(best, dp[i - 1][j][prevCost] + cellScore);
                    }

                    // From left
                    if (j > 0 && dp[i][j - 1][prevCost] != -1) {
                        best = Math.max(best, dp[i][j - 1][prevCost] + cellScore);
                    }

                    dp[i][j][c] = best;
                }
            }
        }

        // Get answer
        int ans = -1;
        for (int c = 0; c <= k; c++) {
            ans = Math.max(ans, dp[m - 1][n - 1][c]);
        }

        return ans;
    }
}