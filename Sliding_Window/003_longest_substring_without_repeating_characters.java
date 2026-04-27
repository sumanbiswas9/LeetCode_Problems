// ============================================================
// Problem    : 3. Longest Substring Without Repeating Characters
// Difficulty : Medium
// URL        : https://leetcode.com/problems/longest-substring-without-repeating-characters/
// Language   : Java
// Date       : 2026-04-27
// ============================================================
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Use Set<Character>, not Set<String>, as we are tracking chars.
        Set<Character> set = new HashSet<>();
        
        int maxCount = 0;
        int left = 0; // The left pointer of the sliding window
        
        // The 'right' pointer iterates through the string
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            
            // If the character is already in our window (set),
            // we must shrink the window from the left until
            // the duplicate is removed.
            while (set.contains(currentChar)) {
                // Remove the character at the 'left' pointer
                set.remove(s.charAt(left));
                // Slide the left pointer to the right
                left++;
            }
            
            // Now that the duplicate is gone (or if there never was one),
            // add the new 'currentChar' to the window.
            set.add(currentChar);
            
            // The current window size is (right - left + 1)
            // Update the maxCount if this window is larger.
            maxCount = Math.max(maxCount, right - left + 1);
        }
        
        return maxCount;
    }
}