// Last updated: 9/9/2026, 9:26:19 AM
1class Solution {
2    public String reverseStr(String s, int k) {
3
4        char[] arr = s.toCharArray();
5
6        for (int start = 0; start < arr.length; start += 2 * k) {
7
8            int left = start;
9            int right = Math.min(start + k - 1, arr.length - 1);
10
11            while (left < right) {
12                char temp = arr[left];
13                arr[left] = arr[right];
14                arr[right] = temp;
15
16                left++;
17                right--;
18            }
19        }
20
21        return new String(arr);
22    }
23}