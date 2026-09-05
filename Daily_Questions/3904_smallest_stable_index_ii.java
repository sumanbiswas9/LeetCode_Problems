// ============================================================
// Problem    : 3904. Smallest Stable Index II
// Difficulty : Medium
// URL        : https://leetcode.com/problems/smallest-stable-index-ii/
// Language   : Java
// Date       : 2026-09-05
// ============================================================
class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int arr[] = new int[nums.length];
        for(int i=nums.length-1;i>=0;i--){
            if(i==nums.length-1)arr[i] = nums[i];
            else{
                arr[i] = Math.min(arr[i+1],nums[i]);
            }
        }
        int max = nums[0];
        for(int i=0;i<nums.length;i++){
            max = Math.max(max,nums[i]);
            if(max-arr[i]<=k) return i;
        }
        return -1;
    }
}