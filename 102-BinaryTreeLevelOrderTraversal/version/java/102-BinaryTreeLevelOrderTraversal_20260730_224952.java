// Last updated: 7/30/2026, 10:49:52 PM
1import java.util.*;
2
3class Solution {
4
5    public List<List<Integer>> levelOrder(TreeNode root) {
6
7        List<List<Integer>> ans = new ArrayList<>();
8
9        if (root == null)
10            return ans;
11
12        Queue<TreeNode> queue = new LinkedList<>();
13        queue.offer(root);
14
15        while (!queue.isEmpty()) {
16
17            int size = queue.size();
18            List<Integer> level = new ArrayList<>();
19
20            for (int i = 0; i < size; i++) {
21
22                TreeNode node = queue.poll();
23
24                level.add(node.val);
25
26                if (node.left != null)
27                    queue.offer(node.left);
28
29                if (node.right != null)
30                    queue.offer(node.right);
31            }
32
33            ans.add(level);
34        }
35
36        return ans;
37    }
38}