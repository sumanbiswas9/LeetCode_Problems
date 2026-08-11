// ============================================================
// Problem    : 2996. Smallest Missing Integer Greater Than Sequential Prefix Sum
// Difficulty : Easy
// URL        : https://leetcode.com/problems/smallest-missing-integer-greater-than-sequential-prefix-sum/
// Language   : Java
// Date       : 2026-08-11
// ============================================================
class Solution {

    public int missingInteger(int[] nums) {
        int n = nums.length;
        Set<Integer> numSet = new HashSet<>(n);
        for (int num : nums) {
            numSet.add(num);
        }
        int total = nums[0];

        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                total += nums[i];
            } else {
                break;
            }
        }

        while (numSet.contains(total)) {
            total += 1;
        }

        return total;
    }
}