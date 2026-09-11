// Last updated: 9/11/2026, 9:13:09 AM
1import java.util.*;
2
3class Solution {
4    public List<Double> averageOfLevels(TreeNode root) {
5
6        List<Double> result = new ArrayList<>();
7
8        Queue<TreeNode> queue = new LinkedList<>();
9        queue.add(root);
10
11        while (!queue.isEmpty()) {
12
13            int size = queue.size();
14            long sum = 0;
15
16            for (int i = 0; i < size; i++) {
17
18                TreeNode node = queue.poll();
19                sum += node.val;
20
21                if (node.left != null) {
22                    queue.add(node.left);
23                }
24
25                if (node.right != null) {
26                    queue.add(node.right);
27                }
28            }
29
30            result.add((double) sum / size);
31        }
32
33        return result;
34    }
35}