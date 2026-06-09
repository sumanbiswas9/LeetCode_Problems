// ============================================================
// Problem    : 3689. Maximum Total Subarray Value I
// Difficulty : Medium
// URL        : https://leetcode.com/problems/maximum-total-subarray-value-i/
// Language   : Java
// Date       : 2026-06-09
// ============================================================
class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int mn = Integer.MAX_VALUE;
        int mx = Integer.MIN_VALUE;

        for (int x : nums) {
            mn = Math.min(mn, x);
            mx = Math.max(mx, x);
        }

        return 1L * k * (mx - mn);
    }
}