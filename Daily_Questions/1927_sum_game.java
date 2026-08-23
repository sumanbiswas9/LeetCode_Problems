// ============================================================
// Problem    : 1927. Sum Game
// Difficulty : Medium
// URL        : https://leetcode.com/problems/sum-game/
// Language   : Java
// Date       : 2026-08-23
// ============================================================
class Solution {
    public boolean sumGame(String num) {
        int leftSum = 0, rightSum = 0;
        int leftQues = 0, rightQues = 0;
        int n = num.length();
        int half = n / 2;

        for (int i = 0; i < n; i++) {
            char ch = num.charAt(i);

            if (i < half) {
                if (ch == '?') leftQues++;
                else leftSum += (ch - '0');
            } else {
                if (ch == '?') rightQues++;
                else rightSum += (ch - '0');
            }
        }

        int diff = leftSum - rightSum;
        int quesDiff = leftQues - rightQues;

        // If odd number of '?' → Alice wins
        if (quesDiff % 2 != 0) return true;

        // Check if Bob can balance
        return diff * 2 != -quesDiff * 9;
    }
}