// ============================================================
// Problem    : 3718. Smallest Missing Multiple of K
// Difficulty : Easy
// URL        : https://leetcode.com/problems/smallest-missing-multiple-of-k/
// Language   : Java
// Date       : 2026-08-25
// ============================================================
class Solution {

    public int missingMultiple(int[] nums, int k) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            seen.add(num);
        }
        int ans = k;
        while (seen.contains(ans)) {
            ans += k;
        }
        return ans;
    }
}