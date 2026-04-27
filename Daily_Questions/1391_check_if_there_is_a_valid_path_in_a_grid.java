// ============================================================
// Problem    : 1391. Check if There is a Valid Path in a Grid
// Difficulty : Medium
// URL        : https://leetcode.com/problems/check-if-there-is-a-valid-path-in-a-grid/
// Language   : Java
// Date       : 2026-04-27
// ============================================================
class Solution {
    boolean canConnect(int[][] grid, Map<Integer, int[][]> streetMap,
                       int row, int col, int newrow, int newcol) {

        int type = grid[newrow][newcol];

        for (int[] dir : streetMap.get(type)) {
            int backRow = newrow + dir[0];
            int backCol = newcol + dir[1];

            // check if it connects back to current cell
            if (backRow == row && backCol == col) return true;
        }
        return false;
    }
    boolean isValid(int[][] grid, Map<Integer, int[][]> streetMap,
                    int row, int col, boolean[][] isVisited) {

        int m = grid.length;
        int n = grid[0].length;

        if (row < 0 || col < 0 || row >= m || col >= n || isVisited[row][col])
            return false;

        if (row == m - 1 && col == n - 1)
            return true;

        isVisited[row][col] = true;

        int pos = grid[row][col];

        for (int[] dir : streetMap.get(pos)) {
            int newrow = row + dir[0];
            int newcol = col + dir[1];

            // boundary check
            if (newrow < 0 || newcol < 0 || newrow >= m || newcol >= n)
                continue;

            // IMPORTANT FIX: check bidirectional connectivity
            if (!canConnect(grid, streetMap, row, col, newrow, newcol))
                continue;

            if (isValid(grid, streetMap, newrow, newcol, isVisited))
                return true;
        }

        return false;
    }

    public boolean hasValidPath(int[][] grid) {
        Map<Integer, int[][]> streetMap = new HashMap<>();

        streetMap.put(1, new int[][]{{0, -1}, {0, 1}});
        streetMap.put(2, new int[][]{{-1, 0}, {1, 0}});
        streetMap.put(3, new int[][]{{0, -1}, {1, 0}});
        streetMap.put(4, new int[][]{{0, 1}, {1, 0}});
        streetMap.put(5, new int[][]{{0, -1}, {-1, 0}});
        streetMap.put(6, new int[][]{{0, 1}, {-1, 0}});

        boolean[][] isVisited = new boolean[grid.length][grid[0].length];

        return isValid(grid, streetMap, 0, 0, isVisited);
    }
}