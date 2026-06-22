// ============================================================
// Problem    : 1189. Maximum Number of Balloons
// Difficulty : Easy
// URL        : https://leetcode.com/problems/maximum-number-of-balloons/
// Language   : Java
// Date       : 2026-06-22
// ============================================================
class Solution {
    public int maxNumberOfBalloons(String text) {
        int []chArr = new int[26];
        for(char ch : text.toCharArray()){
            chArr[ch-'a']++;
        }
        String s = "balloon";
        int ans=0;
        if(chArr['l'-'a']<2 || chArr['o'-'a']<2) return 0;
        while(true){
            for(char ch : s.toCharArray()){
                if(chArr[ch-'a']==0) return ans;
                chArr[ch-'a']--;

            }
            ans++;
        }
    }
}