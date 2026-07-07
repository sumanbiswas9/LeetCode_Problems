// ============================================================
// Problem    : 3754. Concatenate Non-Zero Digits and Multiply by Sum I
// Difficulty : Easy
// URL        : https://leetcode.com/problems/concatenate-non-zero-digits-and-multiply-by-sum-i/
// Language   : Java
// Date       : 2026-07-07
// ============================================================
class Solution {
    public long sumAndMultiply(int n) {
        long sum =0;
        // long num=0;
        String num ="";
        while(n!=0){
            int digit = n%10;
            if(digit!=0){
                num = digit + num;
                sum+=digit;
            }
            n/=10;
        }
        if(num.length()<=0) return 0;
        return sum*Integer.parseInt(num);
    }
}