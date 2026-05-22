// ============================================================
// Problem    : 33. Search in Rotated Sorted Array
// Difficulty : Medium
// URL        : https://leetcode.com/problems/search-in-rotated-sorted-array/
// Language   : Java
// Date       : 2026-05-22
// ============================================================
class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) return mid;

            // Identify which side is sorted
            if (nums[low] <= nums[mid]) {
                // Left side is sorted
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1; // Target is in the sorted left half
                } else {
                    low = mid + 1;  // Target is in the right half
                }
            } else {
                // Right side is sorted
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;  // Target is in the sorted right half
                } else {
                    high = mid - 1; // Target is in the left half
                }
            }
        }
        return -1;
    }
}