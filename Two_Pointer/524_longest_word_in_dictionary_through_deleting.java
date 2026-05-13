// ============================================================
// Problem    : 524. Longest Word in Dictionary through Deleting
// Difficulty : Medium
// URL        : https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/
// Language   : Java
// Date       : 2026-05-13
// ============================================================
class Solution {

    boolean isSubsequence(String s, String word) {
        int i = 0, j = 0;

        while (i < s.length() && j < word.length()) {

            if (s.charAt(i) == word.charAt(j)) {
                j++;
            }

            i++;
        }

        return j == word.length();
    }

    public String findLongestWord(String s, List<String> dictionary) {

        String res = "";

        for (String word : dictionary) {

            if (isSubsequence(s, word)) {

                // longer word found
                if (word.length() > res.length()) {
                    res = word;
                }

                // same length -> lexicographically smaller
                else if (word.length() == res.length()
                        && word.compareTo(res) < 0) {
                    res = word;
                }
            }
        }

        return res;
    }
}