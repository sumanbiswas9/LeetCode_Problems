// ============================================================
// Problem    : 20. Valid Parentheses
// Difficulty : Easy
// URL        : https://leetcode.com/problems/valid-parentheses/
// Language   : Java
// Date       : 2026-04-24
// ============================================================
class Solution {
    public boolean isValid(String s) {
         Deque<Character> stack = new ArrayDeque<Character>();
 
        // Traversing the Expression
        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);
 
            if (x == '(' || x == '[' || x == '{') {
                // Push the element in the stack
                stack.push(x);
                continue;
            }
 
            // If current character is not opening
            // bracket, then it must be closing. So stack
            // cannot be empty at this point.
            if (stack.isEmpty())
                return false;
            char check;
            switch (x) {
            case ')':
                check = stack.pop();
                if (check == '{' || check == '[')
                    return false;
                break;
 
            case '}':
                check = stack.pop();
                if (check == '(' || check == '[')
                    return false;
                break;
 
            case ']':
                check = stack.pop();
                if (check == '(' || check == '{')
                    return false;
                break; 
            }
        }
        return (stack.isEmpty());
    }
}