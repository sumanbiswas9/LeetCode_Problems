// ============================================================
// Problem    : 63. Unique Paths II
// Difficulty : Medium
// URL        : https://leetcode.com/problems/unique-paths-ii/
// Language   : Java
// Date       : 2026-04-24
// ============================================================
class Solution {
    int[][] dp;

    int path(int[][] grid, int sr, int sc) {
        int er = grid.length - 1;
        int ec = grid[0].length - 1;

        // Base cases
        if (sr > er || sc > ec) return 0; // Out of bounds
        if (grid[sr][sc] == 1) return 0; // Blocked cell
        if (sr == er && sc == ec) return 1; // Reached destination

        // If already computed
        if (dp[sr][sc] != -1) return dp[sr][sc];

        // Move down and right
        int down = path(grid, sr + 1, sc);
        int right = path(grid, sr, sc + 1);

        // Store and return result
        return dp[sr][sc] = down + right;
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        dp = new int[m][n];

        // Initialize memoization array with -1
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                dp[i][j] = -1;

        return path(obstacleGrid, 0, 0);
    }
}