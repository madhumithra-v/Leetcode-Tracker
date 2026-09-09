// Last updated: 9/9/2026, 9:37:17 AM
1class Solution {
2    public String reverseWords(String s) {
3
4        char[] arr = s.toCharArray();
5        int start = 0;
6
7        for (int i = 0; i <= arr.length; i++) {
8
9            if (i == arr.length || arr[i] == ' ') {
10
11                int left = start;
12                int right = i - 1;
13
14                while (left < right) {
15                    char temp = arr[left];
16                    arr[left] = arr[right];
17                    arr[right] = temp;
18
19                    left++;
20                    right--;
21                }
22
23                start = i + 1;
24            }
25        }
26
27        return new String(arr);
28    }
29}