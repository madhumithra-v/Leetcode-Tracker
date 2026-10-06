// Last updated: 10/6/2026, 10:10:15 AM
1class MyHashSet {
2
3    private boolean[] set;
4
5    public MyHashSet() {
6        set = new boolean[1000001];
7    }
8
9    public void add(int key) {
10        set[key] = true;
11    }
12
13    public void remove(int key) {
14        set[key] = false;
15    }
16
17    public boolean contains(int key) {
18        return set[key];
19    }
20}