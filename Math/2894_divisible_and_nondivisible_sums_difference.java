// ============================================================
// Problem    : 2894. Divisible and Non-divisible Sums Difference
// Difficulty : Easy
// URL        : https://leetcode.com/problems/divisible-and-non-divisible-sums-difference/
// Language   : Java
// Date       : 2026-04-28
// ============================================================
class Solution {
    public int differenceOfSums(int n, int m) {
        
        int num1=0;
        int num2=0;
        int i=m;
        while(i<=n){
            num2+=i;
            i+=m;
        }
        num1 = ((n*(n+1))/2) - num2;
        return num1-num2;
    }
}