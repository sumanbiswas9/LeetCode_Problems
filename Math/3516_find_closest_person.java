// ============================================================
// Problem    : 3516. Find Closest Person
// Difficulty : Easy
// URL        : https://leetcode.com/problems/find-closest-person/
// Language   : Java
// Date       : 2026-04-28
// ============================================================
class Solution {
    public int findClosest(int x, int y, int z) {
        int a=Math.abs(z-x);
        int b=Math.abs(z-y);
        int c=Math.min(a,b);
        if(a==b)
        {
            return 0;
        }
        else if(c==b)
        {
            return 2;
        }
        else 
        {
            return 1;
        }
    }
}