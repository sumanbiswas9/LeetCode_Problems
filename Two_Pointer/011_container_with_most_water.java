// ============================================================
// Problem    : 11. Container With Most Water
// Difficulty : Medium
// URL        : https://leetcode.com/problems/container-with-most-water/
// Language   : Java
// Date       : 2026-04-24
// ============================================================
class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int currentArea = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, currentArea);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}