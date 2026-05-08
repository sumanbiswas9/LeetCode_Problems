// ============================================================
// Problem    : 297. Serialize and Deserialize Binary Tree
// Difficulty : Hard
// URL        : https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
// Language   : Java
// Date       : 2026-05-08
// ============================================================
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Codec {

    // SERIALIZE
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        return sb.toString();
    }

    private void preorder(TreeNode root, StringBuilder sb) {

        if (root == null) {
            sb.append("#,");
            return;
        }

        sb.append(root.val).append(",");

        preorder(root.left, sb);
        preorder(root.right, sb);
    }

    // DESERIALIZE
    public TreeNode deserialize(String data) {

        String[] arr = data.split(",");

        Queue<String> q = new LinkedList<>();

        for (String s : arr) {
            q.offer(s);
        }

        return buildTree(q);
    }

    private TreeNode buildTree(Queue<String> q) {

        String val = q.poll();

        if (val.equals("#")) {
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(val));

        node.left = buildTree(q);
        node.right = buildTree(q);

        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));