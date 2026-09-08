// Last updated: 9/8/2026, 10:03:01 AM
1class Solution {
2    public int characterReplacement(String s, int k) {
3
4        int[] freq = new int[26];
5
6        int left = 0;
7        int maxFreq = 0;
8        int maxLength = 0;
9
10        for (int right = 0; right < s.length(); right++) {
11
12            int index = s.charAt(right) - 'A';
13            freq[index]++;
14
15            // Highest frequency character in current window
16            maxFreq = Math.max(maxFreq, freq[index]);
17
18            // Characters that need replacement
19            int replacements = (right - left + 1) - maxFreq;
20
21            // Window is invalid
22            if (replacements > k) {
23                freq[s.charAt(left) - 'A']--;
24                left++;
25            }
26
27            maxLength = Math.max(maxLength, right - left + 1);
28        }
29
30        return maxLength;
31    }
32}