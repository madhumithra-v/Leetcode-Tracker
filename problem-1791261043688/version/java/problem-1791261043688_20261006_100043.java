// Last updated: 10/6/2026, 10:00:43 AM
1class Solution {
2    public TreeNode searchBST(TreeNode root, int val) {
3        if (root == null) {
4            return null;
5        }
6
7        if (root.val == val) {
8            return root;
9        }
10
11        if (val < root.val) {
12            return searchBST(root.left, val);
13        }
14
15        return searchBST(root.right, val);
16    }
17}