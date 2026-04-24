// ============================================================
// Problem    : 70. Climbing Stairs
// Difficulty : Easy
// URL        : https://leetcode.com/problems/climbing-stairs/
// Language   : Java
// Date       : 2026-04-24
// ============================================================
/**
 * Solution for the "Climbing Stairs" problem.
 * Goal: Find the number of distinct ways to reach the top of a staircase with n steps,
 * where each time you can take either 1 or 2 steps.
 */
class Solution {

    public int climbStairs(int totalSteps) {
        // Base Case: If there are no steps or only one step, 
        // the number of ways to climb is equal to the number of steps.
        if (totalSteps <= 2) {
            return totalSteps;
        }

        // We use a bottom-up Dynamic Programming approach (Space Optimized).
        // waysToReachTwoStepsBack represents (n-2)
        // waysToReachOneStepBack represents (n-1)
        int waysToReachTwoStepsBack = 1; // Ways to reach step 1
        int waysToReachOneStepBack = 2;  // Ways to reach step 2
        int currentTotalWays = 0;

        // Iterate from the 3rd step up to the target step.
        // Each step's total ways is the sum of the ways to reach the previous two steps.
        for (int currentStep = 3; currentStep <= totalSteps; currentStep++) {
            currentTotalWays = waysToReachOneStepBack + waysToReachTwoStepsBack;
            
            // Shift our pointers forward for the next iteration
            waysToReachTwoStepsBack = waysToReachOneStepBack;
            waysToReachOneStepBack = currentTotalWays;
        }

        return currentTotalWays;
    }
}