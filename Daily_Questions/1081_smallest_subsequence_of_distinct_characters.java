// ============================================================
// Problem    : 1081. Smallest Subsequence of Distinct Characters
// Difficulty : Medium
// URL        : https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/
// Language   : Java
// Date       : 2026-07-19
// ============================================================
class Solution {
    public String smallestSubsequence(String s) {
        int[] last = new int[26];
        for (int i = 0; i < s.length(); i++) last[s.charAt(i) - 'a'] = i;
        boolean[] seen = new boolean[26];
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int idx = c - 'a';
            if (seen[idx]) continue;
            while (!st.isEmpty() && st.peek() > c && last[st.peek() - 'a'] > i) {
                seen[st.pop() - 'a'] = false;
            }
            st.push(c);
            seen[idx] = true;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : st) sb.append(c);
        return sb.toString();
    }
}