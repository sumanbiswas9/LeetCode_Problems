// ============================================================
// Problem    : 119. Pascal's Triangle II
// Difficulty : Easy
// URL        : https://leetcode.com/problems/pascals-triangle-ii/
// Language   : Java
// Date       : 2026-04-26
// ============================================================
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for(int i=1;i<=rowIndex;i++){
            List<Integer> ls = new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(i==0 || j==0 || j==i){
                    ls.add(1);
                }else{
                    ls.add(list.get(j-1) +list.get(j));
                }
            }
            list = ls;
        }
        return list;
    }
}