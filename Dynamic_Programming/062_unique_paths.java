// ============================================================
// Problem    : 62. Unique Paths
// Difficulty : Medium
// URL        : https://leetcode.com/problems/unique-paths/
// Language   : Java
// Date       : 2026-04-24
// ============================================================
class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[2][n];

        // Initialize first row
        for(int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        // Start from row 1 (not 0)
        for(int i = 1; i < m; i++){
            dp[1][0] = 1; // first column

            for(int j = 1; j < n; j++){
                dp[1][j] = dp[0][j] + dp[1][j-1];
            }

            // Copy current row to previous
            for(int j = 0; j < n; j++){
                dp[0][j] = dp[1][j];
            }
        }

        return dp[0][n-1]; // correct result location
    }
}