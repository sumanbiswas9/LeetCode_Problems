// ============================================================
// Problem    : 560. Subarray Sum Equals K
// Difficulty : Medium
// URL        : https://leetcode.com/problems/subarray-sum-equals-k/
// Language   : Java
// Date       : 2026-04-27
// ============================================================
class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1); 

        int sum = 0;
        int count = 0;

        for (int num : nums) {
            sum += num;

            if (prefixSumCount.containsKey(sum - k)) {
                count += prefixSumCount.get(sum - k);
            }

            prefixSumCount.put(sum, prefixSumCount.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}