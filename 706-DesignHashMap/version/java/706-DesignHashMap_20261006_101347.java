// Last updated: 10/6/2026, 10:13:47 AM
1class MyHashMap {
2
3    private int[] map;
4
5    public MyHashMap() {
6        map = new int[1000001];
7
8        for (int i = 0; i < map.length; i++) {
9            map[i] = -1;
10        }
11    }
12
13    public void put(int key, int value) {
14        map[key] = value;
15    }
16
17    public int get(int key) {
18        return map[key];
19    }
20
21    public void remove(int key) {
22        map[key] = -1;
23    }
24}