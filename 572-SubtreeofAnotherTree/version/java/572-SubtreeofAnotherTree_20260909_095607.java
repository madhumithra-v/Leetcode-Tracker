// Last updated: 9/9/2026, 9:56:07 AM
1class Solution {
2    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
3
4        if (subRoot == null) {
5            return true;
6        }
7
8        if (root == null) {
9            return false;
10        }
11
12        if (isSameTree(root, subRoot)) {
13            return true;
14        }
15
16        return isSubtree(root.left, subRoot) ||
17               isSubtree(root.right, subRoot);
18    }
19
20    private boolean isSameTree(TreeNode a, TreeNode b) {
21
22        if (a == null && b == null) {
23            return true;
24        }
25
26        if (a == null || b == null) {
27            return false;
28        }
29
30        if (a.val != b.val) {
31            return false;
32        }
33
34        return isSameTree(a.left, b.left) &&
35               isSameTree(a.right, b.right);
36    }
37}