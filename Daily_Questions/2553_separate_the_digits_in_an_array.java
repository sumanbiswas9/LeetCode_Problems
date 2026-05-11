// ============================================================
// Problem    : 2553. Separate the Digits in an Array
// Difficulty : Easy
// URL        : https://leetcode.com/problems/separate-the-digits-in-an-array/
// Language   : Java
// Date       : 2026-05-11
// ============================================================
class Solution {
     void extractBit(List<Integer> list,int num){
        List<Integer> digits = new ArrayList<>();
        while(num!=0){
            digits.add(num%10);
            num/=10;
        }
        Collections.reverse(digits);
        list.addAll(digits);
     }
    public int[] separateDigits(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int num : nums){
            extractBit(list,num);
        }
        int arr[] = new int[list.size()];
        for(int i=0;i<arr.length;i++){
            arr[i] = list.get(i);
        }
        return arr;
    }
}