// Last updated: 9/11/2026, 9:23:08 AM
1class Solution {
2    public TreeNode trimBST(TreeNode root, int low, int high) {
3
4        if (root == null) {
5            return null;
6        }
7
8        if (root.val < low) {
9            return trimBST(root.right, low, high);
10        }
11
12        if (root.val > high) {
13            return trimBST(root.left, low, high);
14        }
15
16        root.left = trimBST(root.left, low, high);
17        root.right = trimBST(root.right, low, high);
18
19        return root;
20    }
21}