// ============================================================
// Problem    : 5. Longest Palindromic Substring
// Difficulty : Medium
// URL        : https://leetcode.com/problems/longest-palindromic-substring/
// Language   : Java
// Date       : 2026-04-25
// ============================================================
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";

        String t = "^";
        for (char c : s.toCharArray()) {
            t += "#" + c;
        }
        t += "#$";

        int n = t.length();
        int[] p = new int[n];
        int center = 0, right = 0;

        for (int i = 1; i < n - 1; i++) {
            int mirror = 2 * center - i;

            if (i < right) p[i] = Math.min(right - i, p[mirror]);

            while (t.charAt(i + 1 + p[i]) == t.charAt(i - 1 - p[i])) {
                p[i]++;
            }

            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }
        }

        int maxLen = 0;
        int centerIndex = 0;
        for (int i = 1; i < n - 1; i++) {
            if (p[i] > maxLen) {
                maxLen = p[i];
                centerIndex = i;
            }
        }

        int start = (centerIndex - maxLen) / 2;
        return s.substring(start, start + maxLen);
    }
}