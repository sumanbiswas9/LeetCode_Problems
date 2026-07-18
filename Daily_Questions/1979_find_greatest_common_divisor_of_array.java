// ============================================================
// Problem    : 1979. Find Greatest Common Divisor of Array
// Difficulty : Easy
// URL        : https://leetcode.com/problems/find-greatest-common-divisor-of-array/
// Language   : Java
// Date       : 2026-07-18
// ============================================================
class Solution {
    public int findGCD(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        for(int num : nums) {
            min = Math.min(num,min);
            max = Math.max(max,num);
        }
        return gcd(min,max);
    }
    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}