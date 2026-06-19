// ============================================================
// Problem    : 1732. Find the Highest Altitude
// Difficulty : Easy
// URL        : https://leetcode.com/problems/find-the-highest-altitude/
// Language   : Java
// Date       : 2026-06-19
// ============================================================
class Solution {
    public int largestAltitude(int[] gain) {
        int max = 0;
        int g=0;
        for(int val : gain){
            max = Math.max(max,g+val);
            g = g + val;
        }
        return max;
    }
}