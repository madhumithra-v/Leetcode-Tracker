// Last updated: 7/16/2026, 2:47:39 PM
1import java.util.*;
2
3class Solution {
4
5    public String frequencySort(String s) {
6
7        HashMap<Character, Integer> map = new HashMap<>();
8
9        for (char c : s.toCharArray())
10            map.put(c, map.getOrDefault(c, 0) + 1);
11
12        PriorityQueue<Character> pq =
13                new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
14
15        pq.addAll(map.keySet());
16
17        StringBuilder sb = new StringBuilder();
18
19        while (!pq.isEmpty()) {
20
21            char ch = pq.poll();
22
23            for (int i = 0; i < map.get(ch); i++)
24                sb.append(ch);
25        }
26
27        return sb.toString();
28    }
29}