// ============================================================
// Problem    : 26. Remove Duplicates from Sorted Array
// Difficulty : Easy
// URL        : https://leetcode.com/problems/remove-duplicates-from-sorted-array/
// Language   : Java
// Date       : 2026-04-25
// ============================================================
class Solution {
    public int removeDuplicates(int[] nums) {
        int i=0,j=0;
        while(j<nums.length){
            if(nums[i]!=nums[j]) {
                i++;
                nums[i] = nums[j];
            }
            j++;
        }
        return i+1;
    }
}