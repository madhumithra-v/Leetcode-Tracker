// Last updated: 7/30/2026, 10:49:10 PM
1class Solution {
2
3    public boolean isValidBST(TreeNode root) {
4        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
5    }
6
7    private boolean helper(TreeNode node, long min, long max) {
8
9        if (node == null)
10            return true;
11
12        if (node.val <= min || node.val >= max)
13            return false;
14
15        return helper(node.left, min, node.val) &&
16               helper(node.right, node.val, max);
17    }
18}