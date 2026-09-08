// ============================================================
// Problem    : 3870. Count Commas in Range
// Difficulty : Easy
// URL        : https://leetcode.com/problems/count-commas-in-range/
// Language   : Java
// Date       : 2026-09-08
// ============================================================
class Solution {
    public int countCommas(int n) {
        if(n<1000) return 0;
        if(n>=1000) return n-999;
        return 0;
    }
}