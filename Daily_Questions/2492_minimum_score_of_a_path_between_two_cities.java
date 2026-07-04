// ============================================================
// Problem    : 2492. Minimum Score of a Path Between Two Cities
// Difficulty : Medium
// URL        : https://leetcode.com/problems/minimum-score-of-a-path-between-two-cities/
// Language   : Java
// Date       : 2026-07-04
// ============================================================
class Solution {
    private int[] parent, rank_;

    public int minScore(int n, int[][] roads) {
        parent = new int[n + 1];
        rank_ = new int[n + 1];
        for (int i = 0; i <= n; i++) parent[i] = i;

        for (int[] road : roads) {
            union(road[0], road[1]);
        }

        int root = find(1);
        int minScore = Integer.MAX_VALUE;
        for (int[] road : roads) {
            if (find(road[0]) == root) {
                minScore = Math.min(minScore, road[2]);
            }
        }
        return minScore;
    }

    private int find(int x) {
        while (parent[x] != x) {
            parent[x] = parent[parent[x]]; // path compression
            x = parent[x];
        }
        return x;
    }

    private void union(int x, int y) {
        int rx = find(x), ry = find(y);
        if (rx == ry) return;
        if (rank_[rx] < rank_[ry]) { int t = rx; rx = ry; ry = t; }
        parent[ry] = rx;
        if (rank_[rx] == rank_[ry]) rank_[rx]++;
    }
}