// ============================================================
// Problem    : 3289. The Two Sneaky Numbers of Digitville
// Difficulty : Easy
// URL        : https://leetcode.com/problems/the-two-sneaky-numbers-of-digitville/
// Language   : Java
// Date       : 2026-04-28
// ============================================================
class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        
        int []arr=new int[2];
        int k=0;
        for(int i=0;i<nums.length;i++)
        {
            for(int j=i+1;j<nums.length;j++)
            {
                if(nums[i]==nums[j])
                {
                    arr[k]=nums[i];
                    k++;
                    if(k==2)
                    {
                        return arr;
                    }
                }
            }
        }
        return arr;

    }
}