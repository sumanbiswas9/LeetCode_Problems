// ============================================================
// Problem    : 1967. Number of Strings That Appear as Substrings in Word
// Difficulty : Easy
// URL        : https://leetcode.com/problems/number-of-strings-that-appear-as-substrings-in-word/
// Language   : Java
// Date       : 2026-06-29
// ============================================================
class Solution {

    public int numOfStrings(String[] patterns, String word) {
        int res = 0;
        for (String pattern : patterns) {
            if (check(pattern, word)) {
                res++;
            }
        }
        return res;
    }

    private boolean check(String pattern, String word) {
        int m = pattern.length();
        int n = word.length();
        for (int i = 0; i + m <= n; i++) {
            boolean flag = true;
            for (int j = 0; j < m; j++) {
                if (word.charAt(i + j) != pattern.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return true;
            }
        }
        return false;
    }
}