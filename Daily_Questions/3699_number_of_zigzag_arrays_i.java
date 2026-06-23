// ============================================================
// Problem    : 3699. Number of ZigZag Arrays I
// Difficulty : Hard
// URL        : https://leetcode.com/problems/number-of-zigzag-arrays-i/
// Language   : Java
// Date       : 2026-06-23
// ============================================================
class Solution {
    private static final long MOD = 1_000_000_007L;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;

        long[] up = new long[m + 1];
        long[] down = new long[m + 1];

        for (int v = 1; v <= m; v++) {
            up[v] = v - 1;
            down[v] = m - v;
        }

        for (int len = 3; len <= n; len++) {
            long[] newUp = new long[m + 1];
            long[] newDown = new long[m + 1];

            long[] prefDown = new long[m + 1];
            long[] prefUp = new long[m + 1];

            for (int v = 1; v <= m; v++) {
                prefDown[v] = (prefDown[v - 1] + down[v]) % MOD;
                prefUp[v] = (prefUp[v - 1] + up[v]) % MOD;
            }

            long totalUp = prefUp[m];

            for (int v = 1; v <= m; v++) {
                newUp[v] = prefDown[v - 1];

                long val = totalUp - prefUp[v];
                if (val < 0) val += MOD;
                newDown[v] = val;
            }

            up = newUp;
            down = newDown;
        }

        long ans = 0;
        for (int v = 1; v <= m; v++) {
            ans = (ans + up[v] + down[v]) % MOD;
        }

        return (int) ans;
    }
}