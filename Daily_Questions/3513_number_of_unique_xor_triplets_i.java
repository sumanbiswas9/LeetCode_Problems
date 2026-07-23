// ============================================================
// Problem    : 3513. Number of Unique XOR Triplets I
// Difficulty : Medium
// URL        : https://leetcode.com/problems/number-of-unique-xor-triplets-i/
// Language   : Java
// Date       : 2026-07-23
// ============================================================
class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        if(n<=2) return n;
        int b=1;
        int i=1;
        while(i*2<=n){
            b++;
            i = i*2;
        }
        return 1<<b;
    }

}