// ============================================================
// Problem    : 3020. Find the Maximum Number of Elements in Subset
// Difficulty : Medium
// URL        : https://leetcode.com/problems/find-the-maximum-number-of-elements-in-subset/
// Language   : Java
// Date       : 2026-06-27
// ============================================================
class Solution {
    Map<Long, Integer> freq = new HashMap<>();
    Map<Long, Integer> dp = new HashMap<>();

    public int maximumLength(int[] nums) {
        for (int x : nums) {
            freq.put((long)x, freq.getOrDefault((long)x, 0) + 1);
        }

        int ans = 1;

        if (freq.containsKey(1L)) {
            int c = freq.get(1L);
            ans = Math.max(ans, (c % 2 == 0) ? c - 1 : c);
        }

        for (long x : freq.keySet()) {
            if (x != 1) {
                ans = Math.max(ans, solve(x));
            }
        }

        return ans;
    }

    private int solve(long x) {
        if (dp.containsKey(x)) return dp.get(x);

        int res = 1;

        if (freq.getOrDefault(x, 0) >= 2) {
            if (x <= 31622) {
                long y = x * x;
                if (freq.containsKey(y)) {
                    res = Math.max(res, solve(y) + 2);
                }
            }
        }

        dp.put(x, res);
        return res;
    }
}