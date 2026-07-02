// ============================================================
// Problem    : 3286. Find a Safe Walk Through a Grid
// Difficulty : Medium
// URL        : https://leetcode.com/problems/find-a-safe-walk-through-a-grid/
// Language   : Java
// Date       : 2026-07-02
// ============================================================
class Solution {
    int dir[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    boolean dfs(List<List<Integer>> grid, int sr, int sc, int health, boolean[][] isVisited ,int dp[][][]) {

        if (sr < 0 || sc < 0 || sr >= grid.size() || sc >= grid.get(0).size()
                || health == 0 || isVisited[sr][sc])
            return false;
        if(grid.get(sr).get(sc)==1) health--;
        if (sr == grid.size() - 1 && sc == grid.get(0).size() - 1 && health!=0){
            // if(grid.get(grid.size()-1).get(grid.get(0).size()-1)==1 && health==1) return false;
            return true;
        }

        if(dp[sr][sc][health]!=-1) return dp[sr][sc][health]==0?false:true;
        isVisited[sr][sc] = true;

        boolean ans = false;

        for (int[] d : dir) {
            int nr = sr + d[0];
            int nc = sc + d[1];

            if (nr >= 0 && nc >= 0 && nr < grid.size() && nc < grid.get(0).size()) {
                // if (grid.get(nr).get(nc) == 1)
                //     ans |= dfs(grid, nr, nc, health, isVisited,dp);
                // else
                    ans |= dfs(grid, nr, nc, health, isVisited,dp);
            }
        }

        isVisited[sr][sc] = false;
        dp[sr][sc][health]=(ans)?1:0;
        return ans;
    }

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        if (grid.size() == 0)
            return true;
        int m = grid.size();
        int n = grid.get(0).size();
        int dp[][][] = new int[m][n][health+1];


        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<=health;k++){
                    dp[i][j][k]=-1;
                }
            }
        }
        // if(grid.get(0).get(0)==1)health--;
        return dfs(grid, 0, 0, health, new boolean[m][n],dp);
    }
}