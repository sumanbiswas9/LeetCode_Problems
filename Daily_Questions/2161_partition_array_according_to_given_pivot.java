// ============================================================
// Problem    : 2161. Partition Array According to Given Pivot
// Difficulty : Medium
// URL        : https://leetcode.com/problems/partition-array-according-to-given-pivot/
// Language   : Java
// Date       : 2026-06-08
// ============================================================
class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
       int n = nums.length;
      
        // Create a result array of the same size
        int[] result = new int[n];
      
        // Index pointer for placing elements in the result array
        int index = 0;
      
        // First pass: Place all elements less than pivot
        for (int num : nums) {
            if (num < pivot) {
                result[index++] = num;
            }
        }
      
        // Second pass: Place all elements equal to pivot
        for (int num : nums) {
            if (num == pivot) {
                result[index++] = num;
            }
        }
      
        // Third pass: Place all elements greater than pivot
        for (int num : nums) {
            if (num > pivot) {
                result[index++] = num;
            }
        }
      
        return result; 
    }
}