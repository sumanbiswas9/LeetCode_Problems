// ============================================================
// Problem    : 3739. Count Subarrays With Majority Element II
// Difficulty : Hard
// URL        : https://leetcode.com/problems/count-subarrays-with-majority-element-ii/
// Language   : Java
// Date       : 2026-06-26
// ============================================================
class Solution {
    static class Fenwick {
        int[] bit;

        Fenwick(int n) {
            bit = new int[n + 2];
        }

        void add(int idx, int val) {
            while (idx < bit.length) {
                bit[idx] += val;
                idx += idx & -idx;
            }
        }

        int sum(int idx) {
            int res = 0;
            while (idx > 0) {
                res += bit[idx];
                idx -= idx & -idx;
            }
            return res;
        }
    }

    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;

        int offset = n + 2;
        Fenwick bit = new Fenwick(2 * n + 5);

        long ans = 0;
        int pref = 0;

        // prefix sum = 0
        bit.add(offset, 1);

        for (int x : nums) {
            if (x == target)
                pref++;
            else
                pref--;

            ans += bit.sum(pref + offset - 1);
            bit.add(pref + offset, 1);
        }

        return ans;
    }
}