// Last updated: 9/9/2026, 9:28:24 AM
1class Solution {
2
3    int diameter = 0;
4
5    public int diameterOfBinaryTree(TreeNode root) {
6        height(root);
7        return diameter;
8    }
9
10    private int height(TreeNode node) {
11        if (node == null) {
12            return 0;
13        }
14
15        int left = height(node.left);
16        int right = height(node.right);
17
18        diameter = Math.max(diameter, left + right);
19
20        return 1 + Math.max(left, right);
21    }
22}