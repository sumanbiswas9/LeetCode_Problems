// ============================================================
// Problem    : 125. Valid Palindrome
// Difficulty : Easy
// URL        : https://leetcode.com/problems/valid-palindrome/
// Language   : Java
// Date       : 2026-04-27
// ============================================================
class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        char str='a';
        if(s.length()<=1) return true;
        for(int i=0;i<s.length();i++){
            str=s.charAt(i);

            if((str>='A'&& str<='Z')||(str>='a'&&str<='z')||(str>='0'&& str<='9')){
                sb.append(str);
            }
        }
        String newStr=sb.toString().toLowerCase();

        return newStr.equals(sb.reverse().toString().toLowerCase());
        
    }
}