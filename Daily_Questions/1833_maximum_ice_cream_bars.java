// ============================================================
// Problem    : 1833. Maximum Ice Cream Bars
// Difficulty : Medium
// URL        : https://leetcode.com/problems/maximum-ice-cream-bars/
// Language   : Java
// Date       : 2026-06-21
// ============================================================
class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int count =0;
        for(int i=0;i<costs.length;i++){
            if(coins<costs[i]) return count;
            count++;
            coins-=costs[i];
        }
        return count;
    }
}