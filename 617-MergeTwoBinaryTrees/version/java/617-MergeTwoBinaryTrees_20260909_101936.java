// Last updated: 9/9/2026, 10:19:36 AM
1class Solution {
2    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
3
4        if (root1 == null) {
5            return root2;
6        }
7
8        if (root2 == null) {
9            return root1;
10        }
11
12        root1.val += root2.val;
13
14        root1.left = mergeTrees(root1.left, root2.left);
15        root1.right = mergeTrees(root1.right, root2.right);
16
17        return root1;
18    }
19}