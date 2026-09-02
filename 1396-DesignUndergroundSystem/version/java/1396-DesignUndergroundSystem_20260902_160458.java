// Last updated: 9/2/2026, 4:04:58 PM
1import java.util.*;
2
3class UndergroundSystem {
4
5    // passengerId -> [stationName, checkInTime]
6    HashMap<Integer, CheckInData> checkIns;
7
8    // "start#end" -> [totalTime, numberOfTrips]
9    HashMap<String, double[]> trips;
10
11    public UndergroundSystem() {
12        checkIns = new HashMap<>();
13        trips = new HashMap<>();
14    }
15
16    public void checkIn(int id, String stationName, int t) {
17        checkIns.put(id, new CheckInData(stationName, t));
18    }
19
20    public void checkOut(int id, String stationName, int t) {
21
22        CheckInData data = checkIns.get(id);
23
24        String route = data.stationName + "#" + stationName;
25
26        double[] info = trips.getOrDefault(route, new double[2]);
27
28        info[0] += t - data.time;  // total travel time
29        info[1]++;                  // number of trips
30
31        trips.put(route, info);
32
33        checkIns.remove(id);
34    }
35
36    public double getAverageTime(String startStation, String endStation) {
37
38        String route = startStation + "#" + endStation;
39
40        double[] info = trips.get(route);
41
42        return info[0] / info[1];
43    }
44
45    // Helper class
46    class CheckInData {
47        String stationName;
48        int time;
49
50        CheckInData(String stationName, int time) {
51            this.stationName = stationName;
52            this.time = time;
53        }
54    }
55}