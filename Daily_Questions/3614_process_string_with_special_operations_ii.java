// ============================================================
// Problem    : 3614. Process String with Special Operations II
// Difficulty : Hard
// URL        : https://leetcode.com/problems/process-string-with-special-operations-ii/
// Language   : Java
// Date       : 2026-06-17
// ============================================================
class Solution {
    public char processStr(String s, long k) {
        long len = 0;

        // Compute final length
        for (char ch : s.toCharArray()) {
            if (ch == '*') {
                if (len > 0) len--;
            } else if (ch == '#') {
                len *= 2;
            } else if (ch == '%') {
                // length unchanged
            } else {
                len++;
            }

            // Prevent overflow
            len = Math.min(len, Long.MAX_VALUE / 2);
        }

        if (k >= len) return '.';

        // Process operations in reverse
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);

            if (ch == '%') {
                k = len - 1 - k;
            } 
            else if (ch == '#') {
                long prev = len / 2;
                k %= prev;
                len = prev;
            } 
            else if (ch == '*') {
                len++;
            } 
            else {
                long prev = len - 1;

                if (k == prev) {
                    return ch;
                }

                len = prev;
            }
        }

        return '.';
    }
}