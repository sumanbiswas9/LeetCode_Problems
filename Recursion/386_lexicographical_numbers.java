// ============================================================
// Problem    : 386. Lexicographical Numbers
// Difficulty : Medium
// URL        : https://leetcode.com/problems/lexicographical-numbers/
// Language   : Java
// Date       : 2026-05-19
// ============================================================
class Solution {
    private static void generateLexicographical(int current, int limit,List<Integer> res) {
        if (current > limit) {
            return;
        }

        // Print the current valid number
        res.add(current);

        // Append digits 0-9 to the current number to go deeper
        for (int i = 0; i <= 9; i++) {
            int next = current * 10 + i;
            if (next <= limit) {
                generateLexicographical(next, limit,res);
            } else {
                break; // Stop early if next numbers exceed the limit
            }
        }
    }
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ls = new ArrayList<>();
        for(int i=1;i<=9;i++){
            generateLexicographical(i, n,ls);
        }
        return ls;
    }
}