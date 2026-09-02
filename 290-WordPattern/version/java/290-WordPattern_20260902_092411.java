// Last updated: 9/2/2026, 9:24:11 AM
1import java.util.*;
2
3class Solution {
4    public boolean wordPattern(String pattern, String s) {
5
6        String[] words = s.split(" ");
7
8        if (pattern.length() != words.length) {
9            return false;
10        }
11
12        HashMap<Character, String> map = new HashMap<>();
13        HashSet<String> used = new HashSet<>();
14
15        for (int i = 0; i < pattern.length(); i++) {
16
17            char ch = pattern.charAt(i);
18            String word = words[i];
19
20            if (map.containsKey(ch)) {
21                if (!map.get(ch).equals(word)) {
22                    return false;
23                }
24            } else {
25                if (used.contains(word)) {
26                    return false;
27                }
28
29                map.put(ch, word);
30                used.add(word);
31            }
32        }
33
34        return true;
35    }
36}
37