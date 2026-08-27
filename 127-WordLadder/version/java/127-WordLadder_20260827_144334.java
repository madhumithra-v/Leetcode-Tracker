// Last updated: 8/27/2026, 2:43:34 PM
1import java.util.*;
2
3class Solution {
4
5    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
6
7        Set<String> set = new HashSet<>(wordList);
8
9        // If endWord is not present, transformation is impossible
10        if (!set.contains(endWord)) {
11            return 0;
12        }
13
14        Queue<String> queue = new LinkedList<>();
15        queue.offer(beginWord);
16
17        int steps = 1;
18
19        while (!queue.isEmpty()) {
20
21            int size = queue.size();
22
23            for (int i = 0; i < size; i++) {
24
25                String word = queue.poll();
26
27                if (word.equals(endWord)) {
28                    return steps;
29                }
30
31                char[] chars = word.toCharArray();
32
33                // Change each character
34                for (int j = 0; j < chars.length; j++) {
35
36                    char original = chars[j];
37
38                    for (char c = 'a'; c <= 'z'; c++) {
39
40                        if (c == original) {
41                            continue;
42                        }
43
44                        chars[j] = c;
45
46                        String nextWord = new String(chars);
47
48                        if (set.contains(nextWord)) {
49                            queue.offer(nextWord);
50                            set.remove(nextWord);
51                        }
52                    }
53
54                    chars[j] = original;
55                }
56            }
57
58            steps++;
59        }
60
61        return 0;
62    }
63}