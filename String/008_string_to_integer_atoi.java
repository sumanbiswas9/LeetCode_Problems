// ============================================================
// Problem    : 8. String to Integer (atoi)
// Difficulty : Medium
// URL        : https://leetcode.com/problems/string-to-integer-atoi/
// Language   : Java
// Date       : 2026-05-15
// ============================================================
class Solution {
    public int myAtoi(String s) {
        int index = 0;
        int sign = 1;
        int result = 0;

        // Step 1: Ignore leading whitespace
        while (index < s.length() && s.charAt(index) == ' ') {
            index++;
        }

        // Step 2: Check for '+' or '-'
        if (index < s.length() && (s.charAt(index) == '+' || s.charAt(index) == '-')) {
            sign = (s.charAt(index) == '-') ? -1 : 1;
            index++;
        }

        // Step 3: Read in characters until the next non-digit character or end of input
        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            int digit = s.charAt(index) - '0';

            // Step 4: Check for integer overflow/underflow
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > 7)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            index++;
        }

        // Step 5: Apply sign and return the result
        return result * sign;
    }


}