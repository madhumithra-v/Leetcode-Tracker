// Last updated: 9/2/2026, 4:21:20 PM
1import java.util.*;
2
3class RandomizedSet {
4
5    private ArrayList<Integer> list;
6    private HashMap<Integer, Integer> map;
7    private Random random;
8
9    public RandomizedSet() {
10        list = new ArrayList<>();
11        map = new HashMap<>();
12        random = new Random();
13    }
14
15    public boolean insert(int val) {
16
17        if (map.containsKey(val)) {
18            return false;
19        }
20
21        map.put(val, list.size());
22        list.add(val);
23
24        return true;
25    }
26
27    public boolean remove(int val) {
28
29        if (!map.containsKey(val)) {
30            return false;
31        }
32
33        int index = map.get(val);
34        int lastValue = list.get(list.size() - 1);
35
36        // Move last element to the deleted element's position
37        list.set(index, lastValue);
38        map.put(lastValue, index);
39
40        // Remove last element
41        list.remove(list.size() - 1);
42        map.remove(val);
43
44        return true;
45    }
46
47    public int getRandom() {
48
49        int index = random.nextInt(list.size());
50
51        return list.get(index);
52    }
53}