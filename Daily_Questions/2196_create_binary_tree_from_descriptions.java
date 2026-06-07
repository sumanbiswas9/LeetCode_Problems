// ============================================================
// Problem    : 2196. Create Binary Tree From Descriptions
// Difficulty : Medium
// URL        : https://leetcode.com/problems/create-binary-tree-from-descriptions/
// Language   : Java
// Date       : 2026-06-07
// ============================================================
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer,TreeNode> parent = new HashMap<>();
        Map<Integer,TreeNode> child = new HashMap<>();
        for(int[] description : descriptions){
            parent.putIfAbsent(description[0],new TreeNode(description[0]));
            parent.putIfAbsent(description[1],new TreeNode(description[1]));
            child.putIfAbsent(description[1],new TreeNode(description[1]));
        }
        for(int[] description : descriptions){
            TreeNode parenti = parent.get(description[0]);
            TreeNode childi = parent.get(description[1]);
            int isLeft = description[2];
            if(isLeft==1) parenti.left=childi;
            else parenti.right=childi;
        }
        for(Map.Entry<Integer,TreeNode> entry : parent.entrySet()){
            if(!child.containsKey(entry.getKey())) return entry.getValue();
        }
        return null;
    }
}