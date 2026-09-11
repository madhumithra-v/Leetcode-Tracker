// Last updated: 9/11/2026, 9:19:10 AM
1import java.util.*;
2
3class Solution {
4    public boolean findTarget(TreeNode root, int k) {
5
6        Set<Integer> set = new HashSet<>();
7
8        return search(root, k, set);
9    }
10
11    private boolean search(TreeNode node, int k, Set<Integer> set) {
12
13        if (node == null) {
14            return false;
15        }
16
17        if (set.contains(k - node.val)) {
18            return true;
19        }
20
21        set.add(node.val);
22
23        return search(node.left, k, set) ||
24               search(node.right, k, set);
25    }
26}