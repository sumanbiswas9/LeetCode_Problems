// ============================================================
// Problem    : 58. Length of Last Word
// Difficulty : Easy
// URL        : https://leetcode.com/problems/length-of-last-word/
// Language   : Java
// Date       : 2026-04-27
// ============================================================
class Solution {
    public int lengthOfLastWord(String s) {
        // Start from the end of the string
        int endIndex = s.length() - 1;
      
        // Skip trailing spaces from the end
        while (endIndex >= 0 && s.charAt(endIndex) == ' ') {
            endIndex--;
        }
      
        // Mark the end position of the last word
        int startIndex = endIndex;
      
        // Move backwards to find the start of the last word
        // Stop when we encounter a space or reach the beginning
        while (startIndex >= 0 && s.charAt(startIndex) != ' ') {
            startIndex--;
        }
      
        // Calculate the length of the last word
        // startIndex points to the space before the word (or -1 if at beginning)
        // endIndex points to the last character of the word
        return endIndex - startIndex;
    }
}