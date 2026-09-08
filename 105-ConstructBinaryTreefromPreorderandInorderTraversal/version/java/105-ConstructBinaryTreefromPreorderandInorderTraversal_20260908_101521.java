// Last updated: 9/8/2026, 10:15:21 AM
1import java.util.*;
2
3class Solution {
4
5    HashMap<Integer, Integer> map;
6    int preorderIndex = 0;
7
8    public TreeNode buildTree(int[] preorder, int[] inorder) {
9
10        map = new HashMap<>();
11
12        // Store inorder value -> index
13        for (int i = 0; i < inorder.length; i++) {
14            map.put(inorder[i], i);
15        }
16
17        return build(preorder, 0, inorder.length - 1);
18    }
19
20    private TreeNode build(int[] preorder, int left, int right) {
21
22        if (left > right) {
23            return null;
24        }
25
26        // First element in preorder is the root
27        int rootValue = preorder[preorderIndex++];
28
29        TreeNode root = new TreeNode(rootValue);
30
31        // Find root position in inorder
32        int rootIndex = map.get(rootValue);
33
34        // Build left subtree
35        root.left = build(preorder, left, rootIndex - 1);
36
37        // Build right subtree
38        root.right = build(preorder, rootIndex + 1, right);
39
40        return root;
41    }
42}