// ============================================================
// Problem    : 1800. Maximum Ascending Subarray Sum
// Difficulty : Easy
// URL        : https://leetcode.com/problems/maximum-ascending-subarray-sum/
// Language   : Java
// Date       : 2026-05-21
// ============================================================
class Solution {
    public int maxAscendingSum(int[] nums) {
        int max = nums[0];
        int curr=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]<=nums[i-1]){
                max = Math.max(max,curr);
                curr=0;
            }
            curr+=nums[i];
        }

        return Math.max(max,curr);
    }
}