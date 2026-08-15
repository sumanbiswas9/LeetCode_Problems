// ============================================================
// Problem    : 3702. Longest Subsequence With Non-Zero Bitwise XOR
// Difficulty : Medium
// URL        : https://leetcode.com/problems/longest-subsequence-with-non-zero-bitwise-xor/
// Language   : Java
// Date       : 2026-08-15
// ============================================================
class Solution {

    public int longestSubsequence(int[] nums) {
        int n = nums.length;
        int totalXor = 0;
        boolean allZero = true;

        for (int x : nums) {
            totalXor ^= x;
            if (x > 0) {
                allZero = false;
            }
        }
        if (totalXor > 0) {
            return n;
        }

        return allZero ? 0 : n - 1;
    }
}