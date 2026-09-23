// ============================================================
// Problem    : 1658. Minimum Operations to Reduce X to Zero
// Difficulty : Medium
// URL        : https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/
// Language   : Java
// Date       : 2026-09-23
// ============================================================
class Solution {
    public int minOperations(int[] A, int x) {
        int k = -x, n = A.length;
        for (int a : A) k += a;
        if (k < 0) return -1;
        if (k == 0) return n;

        int best = -1, i = 0, s = 0;
        for (int j = 0; j < n; j++) {
            s += A[j];
            while (s > k)
                s -= A[i++];

            if (s == k)
                best = Math.max(best, j - i + 1);
        }

        return best < 0 ? -1 : n - best;
    }
}