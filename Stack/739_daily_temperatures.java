// ============================================================
// Problem    : 739. Daily Temperatures
// Difficulty : Medium
// URL        : https://leetcode.com/problems/daily-temperatures/
// Language   : Java
// Date       : 2026-04-29
// ============================================================
import java.util.Stack;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                answer[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        
        return answer;
    }
}