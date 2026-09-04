// ============================================================
// Problem    : 3903. Smallest Stable Index I
// Difficulty : Easy
// URL        : https://leetcode.com/problems/smallest-stable-index-i/
// Language   : Java
// Date       : 2026-09-04
// ============================================================
class Solution {
    public int firstStableIndex(int[] nums, int k) {
        // int min = Integer.MAX_VALUE;
        // if(nums.length==1) return nums[0]-nums[0]<=k ? nums[0]-nums[0] : -1;
        int max = nums[0];
        for(int i=0;i<nums.length;i++){
            max = Math.max(nums[i],max);
            int min = nums[i];
            for(int j = i+1;j<nums.length;j++){
                min = Math.min(min,nums[j]);
            }
            if(max-min<=k){
                return i;
            }
        }
        return -1;
    }
}