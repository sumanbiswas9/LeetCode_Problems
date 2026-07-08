// ============================================================
// Problem    : 3756. Concatenate Non-Zero Digits and Multiply by Sum II
// Difficulty : Medium
// URL        : https://leetcode.com/problems/concatenate-non-zero-digits-and-multiply-by-sum-ii/
// Language   : Java
// Date       : 2026-07-08
// ============================================================
import java.util.*;

class Solution {

    static final int MOD = 1_000_000_007;

    public int[] sumAndMultiply(String s, int[][] queries) {

        int n = s.length();

        // Prefix sum of digits
        long[] prefixSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + (s.charAt(i) - '0');
        }

        // Non-zero positions and digits
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> digit = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int d = s.charAt(i) - '0';
            if (d != 0) {
                pos.add(i);
                digit.add(d);
            }
        }

        int m = digit.size();

        long[] pref = new long[m + 1];
        long[] pow10 = new long[m + 1];

        pow10[0] = 1;
        for (int i = 1; i <= m; i++)
            pow10[i] = (pow10[i - 1] * 10) % MOD;

        for (int i = 0; i < m; i++)
            pref[i + 1] = (pref[i] * 10 + digit.get(i)) % MOD;

        int[] ans = new int[queries.length];

        for (int q = 0; q < queries.length; q++) {

            int l = queries[q][0];
            int r = queries[q][1];

            long sum = prefixSum[r + 1] - prefixSum[l];

            int left = lowerBound(pos, l);
            int right = upperBound(pos, r) - 1;

            if (left > right) {
                ans[q] = 0;
                continue;
            }

            int cnt = right - left + 1;

            long value = (pref[right + 1]
                    - (pref[left] * pow10[cnt]) % MOD
                    + MOD) % MOD;

            ans[q] = (int) ((sum % MOD) * value % MOD);
        }

        return ans;
    }

    private int lowerBound(ArrayList<Integer> arr, int target) {
        int l = 0, r = arr.size();
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr.get(mid) >= target)
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }

    private int upperBound(ArrayList<Integer> arr, int target) {
        int l = 0, r = arr.size();
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr.get(mid) > target)
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }
}