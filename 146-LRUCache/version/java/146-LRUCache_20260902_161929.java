// Last updated: 9/2/2026, 4:19:29 PM
1import java.util.*;
2
3class LRUCache {
4
5    class Node {
6        int key;
7        int value;
8        Node prev;
9        Node next;
10
11        Node(int key, int value) {
12            this.key = key;
13            this.value = value;
14        }
15    }
16
17    private int capacity;
18    private HashMap<Integer, Node> map;
19
20    private Node head;
21    private Node tail;
22
23    public LRUCache(int capacity) {
24        this.capacity = capacity;
25        map = new HashMap<>();
26
27        // Dummy nodes
28        head = new Node(0, 0);
29        tail = new Node(0, 0);
30
31        head.next = tail;
32        tail.prev = head;
33    }
34
35    public int get(int key) {
36
37        if (!map.containsKey(key)) {
38            return -1;
39        }
40
41        Node node = map.get(key);
42
43        // Mark as recently used
44        remove(node);
45        addToFront(node);
46
47        return node.value;
48    }
49
50    public void put(int key, int value) {
51
52        // If key already exists
53        if (map.containsKey(key)) {
54            Node node = map.get(key);
55
56            node.value = value;
57
58            remove(node);
59            addToFront(node);
60
61            return;
62        }
63
64        // Create new node
65        Node node = new Node(key, value);
66
67        map.put(key, node);
68        addToFront(node);
69
70        // Cache is full
71        if (map.size() > capacity) {
72
73            Node lru = tail.prev;
74
75            remove(lru);
76            map.remove(lru.key);
77        }
78    }
79
80    // Remove node
81    private void remove(Node node) {
82
83        node.prev.next = node.next;
84        node.next.prev = node.prev;
85    }
86
87    // Add node to front
88    private void addToFront(Node node) {
89
90        node.next = head.next;
91        node.prev = head;
92
93        head.next.prev = node;
94        head.next = node;
95    }
96}