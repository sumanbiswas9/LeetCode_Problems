// ============================================================
// Problem    : 121. Best Time to Buy and Sell Stock
// Difficulty : Easy
// URL        : https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
// Language   : Java
// Date       : 2026-04-27
// ============================================================
class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int maxProfit=0;
        for(int price : prices){
            int profit = price - min;
            min = Math.min(min,price);
            maxProfit = Math.max(profit,maxProfit);
        }
        return maxProfit;
    }
}