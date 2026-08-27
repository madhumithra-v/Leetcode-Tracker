// Last updated: 8/27/2026, 2:50:49 PM
1import java.util.*;
2
3class Solution {
4
5    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
6
7        // Map each node to its parent
8        Map<TreeNode, TreeNode> parent = new HashMap<>();
9        buildParentMap(root, null, parent);
10
11        List<Integer> result = new ArrayList<>();
12
13        // BFS starting from target
14        Queue<TreeNode> queue = new LinkedList<>();
15        Set<TreeNode> visited = new HashSet<>();
16
17        queue.offer(target);
18        visited.add(target);
19
20        int distance = 0;
21
22        while (!queue.isEmpty()) {
23
24            int size = queue.size();
25
26            // Reached distance K
27            if (distance == k) {
28                while (!queue.isEmpty()) {
29                    result.add(queue.poll().val);
30                }
31                return result;
32            }
33
34            for (int i = 0; i < size; i++) {
35
36                TreeNode current = queue.poll();
37
38                // Left child
39                if (current.left != null &&
40                    !visited.contains(current.left)) {
41
42                    visited.add(current.left);
43                    queue.offer(current.left);
44                }
45
46                // Right child
47                if (current.right != null &&
48                    !visited.contains(current.right)) {
49
50                    visited.add(current.right);
51                    queue.offer(current.right);
52                }
53
54                // Parent
55                TreeNode p = parent.get(current);
56
57                if (p != null && !visited.contains(p)) {
58
59                    visited.add(p);
60                    queue.offer(p);
61                }
62            }
63
64            distance++;
65        }
66
67        return result;
68    }
69
70    private void buildParentMap(
71        TreeNode node,
72        TreeNode parentNode,
73        Map<TreeNode, TreeNode> parent
74    ) {
75
76        if (node == null) {
77            return;
78        }
79
80        parent.put(node, parentNode);
81
82        buildParentMap(node.left, node, parent);
83        buildParentMap(node.right, node, parent);
84    }
85}