// ============================================================
// Problem    : 32. Longest Valid Parentheses
// Difficulty : Hard
// URL        : https://leetcode.com/problems/longest-valid-parentheses/
// Language   : Java
// Date       : 2026-04-25
// ============================================================
class Solution {
    public int longestValidParentheses(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1); // base index
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }
        return maxLen;
    }
}