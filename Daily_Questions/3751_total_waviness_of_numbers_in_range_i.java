// ============================================================
// Problem    : 3751. Total Waviness of Numbers in Range I
// Difficulty : Medium
// URL        : https://leetcode.com/problems/total-waviness-of-numbers-in-range-i/
// Language   : Java
// Date       : 2026-06-04
// ============================================================
class Solution {
    public int totalWaviness(int num1, int num2) {
        int count=0;
       for(int i=num1; i<=num2; i++){
        String s=Integer.toString(i);
        for(int j=1; j<s.length()-1; j++){
            if(( s.charAt(j)-'0')>(s.charAt(j-1)-'0') && (s.charAt(j)-'0')>(s.charAt(j+1)-'0')){
                count++;
            }
            else if((s.charAt(j)-'0')<(s.charAt(j-1)-'0') && (s.charAt(j)-'0')<(s.charAt(j+1)-'0')){
                count++;
            }
        }
       } 
       return count;
    }
}