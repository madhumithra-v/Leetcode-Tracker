// Last updated: 8/27/2026, 2:45:56 PM
1class Solution {
2
3    int maxSum = Integer.MIN_VALUE;
4
5    public int maxPathSum(TreeNode root) {
6        findMaxPath(root);
7        return maxSum;
8    }
9
10    private int findMaxPath(TreeNode node) {
11
12        if (node == null) {
13            return 0;
14        }
15
16        // Ignore negative paths
17        int left = Math.max(0, findMaxPath(node.left));
18        int right = Math.max(0, findMaxPath(node.right));
19
20        // Path passing through current node
21        int currentPath = node.val + left + right;
22
23        // Update global maximum
24        maxSum = Math.max(maxSum, currentPath);
25
26        // Return the best one-sided path to parent
27        return node.val + Math.max(left, right);
28    }
29}