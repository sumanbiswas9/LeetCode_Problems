// ============================================================
// Problem    : 3536. Maximum Product of Two Digits
// Difficulty : Easy
// URL        : https://leetcode.com/problems/maximum-product-of-two-digits/
// Language   : Java
// Date       : 2026-07-25
// ============================================================
class Solution {
    public int maxProduct(int n) {
        int max = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;

        while (n != 0) {
            int digit = n % 10;

            if (digit >= max) {
                max2 = max;
                max = digit;
            } else if (digit > max2) {
                max2 = digit;
            }

            n /= 10;
        }

        return max * max2;
    }
}