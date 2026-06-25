// ============================================================
// Problem    : 3737. Count Subarrays With Majority Element I
// Difficulty : Medium
// URL        : https://leetcode.com/problems/count-subarrays-with-majority-element-i/
// Language   : Java
// Date       : 2026-06-25
// ============================================================
class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int freq = 0;
            for (int j = i; j < n; j++) {
                if (nums[j] == target) freq++;

                int len = j - i + 1;
                if (freq > len / 2) ans++;
            }
        }

        return ans;
    }
}