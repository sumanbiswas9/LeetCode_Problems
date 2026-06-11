// ============================================================
// Problem    : 3558. Number of Ways to Assign Edge Weights I
// Difficulty : Medium
// URL        : https://leetcode.com/problems/number-of-ways-to-assign-edge-weights-i/
// Language   : Java
// Date       : 2026-06-11
// ============================================================
import java.util.*;

class Solution {
    private static final long MOD = 1_000_000_007L;

    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 1;

        // Build adjacency list
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            graph[u].add(v);
            graph[v].add(u);
        }

        // BFS to find maximum depth from root (node 1)
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];

        q.offer(1);
        visited[1] = true;

        int depth = -1;

        while (!q.isEmpty()) {
            int size = q.size();
            depth++;

            for (int i = 0; i < size; i++) {
                int node = q.poll();

                for (int nei : graph[node]) {
                    if (!visited[nei]) {
                        visited[nei] = true;
                        q.offer(nei);
                    }
                }
            }
        }

        // Single node tree
        if (depth == 0) return 0;

        return (int) modPow(2, depth - 1);
    }

    private long modPow(long base, long exp) {
        long res = 1;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = (res * base) % MOD;
            }
            base = (base * base) % MOD;
            exp >>= 1;
        }

        return res;
    }
}