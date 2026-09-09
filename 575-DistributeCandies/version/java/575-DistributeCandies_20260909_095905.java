// Last updated: 9/9/2026, 9:59:05 AM
1import java.util.*;
2
3class Solution {
4    public int distributeCandies(int[] candyType) {
5
6        Set<Integer> types = new HashSet<>();
7
8        for (int candy : candyType) {
9            types.add(candy);
10        }
11
12        return Math.min(types.size(), candyType.length / 2);
13    }
14}