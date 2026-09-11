// ============================================================
// Problem    : 41. First Missing Positive
// Difficulty : Hard
// URL        : https://leetcode.com/problems/first-missing-positive/
// Language   : Java
// Date       : 2026-09-11
// ============================================================
class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]<=0||nums[i]>n) nums[i] = n+1;
        }
        for(int i=0;i<n;i++){
            int val = Math.abs(nums[i]);
            if(val<=n){
                nums[val-1]=-(Math.abs(nums[val-1]));
            }
        }
        for(int i=0;i<n;i++){
            if(nums[i]>0) return i+1;
        }

        return n+1;
    }
}