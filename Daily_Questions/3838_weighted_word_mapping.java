// ============================================================
// Problem    : 3838. Weighted Word Mapping
// Difficulty : Easy
// URL        : https://leetcode.com/problems/weighted-word-mapping/
// Language   : Java
// Date       : 2026-06-13
// ============================================================
class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        var ans = new StringBuilder();
        for (var w : words) {
            int s = 0;
            for (char c : w.toCharArray()) {
                s = (s + weights[c - 'a']) % 26;
            }
            ans.append((char) ('a' + (25 - s)));
        }
        return ans.toString();
    }
}