// Last updated: 8/27/2026, 2:57:59 PM
1import java.util.*;
2
3class TimeMap {
4
5    private Map<String, List<Pair>> map;
6
7    public TimeMap() {
8        map = new HashMap<>();
9    }
10
11    public void set(String key, String value, int timestamp) {
12
13        map.putIfAbsent(key, new ArrayList<>());
14
15        map.get(key).add(new Pair(value, timestamp));
16    }
17
18    public String get(String key, int timestamp) {
19
20        if (!map.containsKey(key)) {
21            return "";
22        }
23
24        List<Pair> list = map.get(key);
25
26        int left = 0;
27        int right = list.size() - 1;
28
29        String answer = "";
30
31        while (left <= right) {
32
33            int mid = left + (right - left) / 2;
34
35            if (list.get(mid).timestamp <= timestamp) {
36                answer = list.get(mid).value;
37                left = mid + 1;
38            } else {
39                right = mid - 1;
40            }
41        }
42
43        return answer;
44    }
45
46    static class Pair {
47        String value;
48        int timestamp;
49
50        Pair(String value, int timestamp) {
51            this.value = value;
52            this.timestamp = timestamp;
53        }
54    }
55}