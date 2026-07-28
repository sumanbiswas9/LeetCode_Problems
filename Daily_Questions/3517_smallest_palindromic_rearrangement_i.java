// ============================================================
// Problem    : 3517. Smallest Palindromic Rearrangement I
// Difficulty : Medium
// URL        : https://leetcode.com/problems/smallest-palindromic-rearrangement-i/
// Language   : Java
// Date       : 2026-07-28
// ============================================================
class Solution {
    public String smallestPalindrome(String s) {
        int[] arr = new int[26];

        for (char ch : s.toCharArray()) {
            arr[ch - 'a']++;
        }

        StringBuilder left = new StringBuilder();
        int idx = -1;

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < arr[i] / 2; j++) {
                left.append((char) ('a' + i));
            }

            if (arr[i] % 2 == 1) {
                idx = i;
            }
        }

        String first = left.toString();
        String second = new StringBuilder(first).reverse().toString();

        String middle = "";
        if (idx != -1) {
            middle = String.valueOf((char) ('a' + idx));
        }

        return first + middle + second;
    }
}