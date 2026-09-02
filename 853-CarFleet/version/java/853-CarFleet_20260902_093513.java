// Last updated: 9/2/2026, 9:35:13 AM
1import java.util.*;
2
3class Solution {
4    public int carFleet(int target, int[] position, int[] speed) {
5
6        int n = position.length;
7
8        // Store cars as [position, speed]
9        int[][] cars = new int[n][2];
10
11        for (int i = 0; i < n; i++) {
12            cars[i][0] = position[i];
13            cars[i][1] = speed[i];
14        }
15
16        // Sort cars by position from closest to target
17        Arrays.sort(cars, (a, b) -> Integer.compare(b[0], a[0]));
18
19        int fleets = 0;
20        double lastTime = 0;
21
22        for (int i = 0; i < n; i++) {
23
24            int pos = cars[i][0];
25            int spd = cars[i][1];
26
27            // Time needed to reach target
28            double time = (double) (target - pos) / spd;
29
30            // If this car takes longer, it forms a new fleet
31            if (time > lastTime) {
32                fleets++;
33                lastTime = time;
34            }
35        }
36
37        return fleets;
38    }
39}