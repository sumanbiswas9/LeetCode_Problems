// ============================================================
// Problem    : 3963. Create Grid With Exactly One Path
// Difficulty : Easy
// URL        : https://leetcode.com/problems/create-grid-with-exactly-one-path/
// Language   : Java
// Date       : 2026-10-27
// ============================================================
import java.util.Arrays;

class Solution {
    public String[] createGrid(int m, int n) {
        // Create a 2D character array to represent the m x n grid
        char[][] grid = new char[m][n];
        
        // Step 1: Fill the entire grid with obstacle characters ('#')
        for (int i = 0; i < m; i++) {
            Arrays.fill(grid[i], '#');
        }
        
        // Step 2: Open up the entire first row by setting cells to free ('.')
        Arrays.fill(grid[0], '.');
        
        // Step 3: Open up the entire last column by setting cells to free ('.')
        for (int i = 0; i < m; i++) {
            grid[i][n - 1] = '.';
        }
        
        // Step 4: Convert each row character array into a String
        String[] result = new String[m];
        for (int i = 0; i < m; i++) {
            result[i] = new String(grid[i]);
        }
        
        // Return the final grid configuration
        return result;
    }
}