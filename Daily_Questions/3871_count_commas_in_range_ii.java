// ============================================================
// Problem    : 3871. Count Commas in Range II
// Difficulty : Medium
// URL        : https://leetcode.com/problems/count-commas-in-range-ii/
// Language   : Java
// Date       : 2026-09-09
// ============================================================
class Solution {
    public long countCommas(long n) {
         long result = 0;
        
        long start = 1000; // first number with comma
        int commas = 1;
        
        while (start <= n) {
            long end = start * 1000 - 1;
            
            long count = Math.min(n, end) - start + 1;
            if (count > 0) {
                result += count * commas;
            }
            
            start *= 1000;
            commas++;
        }
        
        return result;
    }
}