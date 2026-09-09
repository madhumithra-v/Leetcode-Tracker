// Last updated: 9/9/2026, 10:15:28 AM
1class Solution {
2    public String tree2str(TreeNode root) {
3
4        if (root == null) {
5            return "";
6        }
7
8        StringBuilder sb = new StringBuilder();
9        build(root, sb);
10
11        return sb.toString();
12    }
13
14    private void build(TreeNode node, StringBuilder sb) {
15
16        if (node == null) {
17            return;
18        }
19
20        sb.append(node.val);
21
22        if (node.left != null || node.right != null) {
23            sb.append("(");
24            build(node.left, sb);
25            sb.append(")");
26        }
27
28        if (node.right != null) {
29            sb.append("(");
30            build(node.right, sb);
31            sb.append(")");
32        }
33    }
34}