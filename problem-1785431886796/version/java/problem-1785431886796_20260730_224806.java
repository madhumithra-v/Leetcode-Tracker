// Last updated: 7/30/2026, 10:48:06 PM
1class Solution {
2
3    public TreeNode invertTree(TreeNode root) {
4
5        if (root == null)
6            return null;
7
8        TreeNode temp = root.left;
9        root.left = root.right;
10        root.right = temp;
11
12        invertTree(root.left);
13        invertTree(root.right);
14
15        return root;
16    }
17}