// ============================================================
// Problem    : 3345. Smallest Divisible Digit Product I
// Difficulty : Easy
// URL        : https://leetcode.com/problems/smallest-divisible-digit-product-i/
// Language   : Java
// Date       : 2026-08-06
// ============================================================
class Solution {
    public int smallestNumber(int n, int t) {
        int number = n;
        while(true){
            int num = number;
            int product=1;
            while(num!=0){
                product*=num%10;
                num /=10;
            }
            if(product%t==0) return number;
            number++;
        }
        // return -1;
    }
}