// ============================================================
// Problem    : 3876. Construct Uniform Parity Array II
// Difficulty : Medium
// URL        : https://leetcode.com/problems/construct-uniform-parity-array-ii/
// Language   : Java
// Date       : 2026-09-03
// ============================================================
import java.util.*;

class Solution {
    public boolean uniformArray(int[] nums1) {
        Arrays.sort(nums1);

        int n = nums1.length;

        // Try making all EVEN
        boolean canEven = true;
        for (int i = 0; i < n; i++) {
            if (nums1[i] % 2 != 0) { // odd
                boolean found = false;
                for (int j = 0; j < i; j++) {
                    if (nums1[j] % 2 != 0) { // smaller odd
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    canEven = false;
                    break;
                }
            }
        }

        // Try making all ODD
        boolean canOdd = true;
        for (int i = 0; i < n; i++) {
            if (nums1[i] % 2 == 0) { // even
                boolean found = false;
                for (int j = 0; j < i; j++) {
                    if (nums1[j] % 2 != 0) { // smaller odd
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    canOdd = false;
                    break;
                }
            }
        }

        return canEven || canOdd;
    }
}