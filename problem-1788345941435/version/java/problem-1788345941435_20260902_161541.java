// Last updated: 9/2/2026, 4:15:41 PM
1import java.util.*;
2
3class Solution {
4    public List<Integer> rightSideView(TreeNode root) {
5
6        List<Integer> result = new ArrayList<>();
7
8        if (root == null) {
9            return result;
10        }
11
12        Queue<TreeNode> queue = new LinkedList<>();
13        queue.offer(root);
14
15        while (!queue.isEmpty()) {
16
17            int size = queue.size();
18
19            for (int i = 0; i < size; i++) {
20
21                TreeNode node = queue.poll();
22
23                // Last node of each level
24                if (i == size - 1) {
25                    result.add(node.val);
26                }
27
28                if (node.left != null) {
29                    queue.offer(node.left);
30                }
31
32                if (node.right != null) {
33                    queue.offer(node.right);
34                }
35            }
36        }
37
38        return result;
39    }
40}