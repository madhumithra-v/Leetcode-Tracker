// Last updated: 7/9/2026, 3:08:47 PM
class Solution {

    private int start = 0;
    private int maxLength = 0;

    public String longestPalindrome(String s) {

        if (s == null || s.length() < 1)
            return "";

        for (int i = 0; i < s.length(); i++) {

            expandFromCenter(s, i, i);       // Odd length
            expandFromCenter(s, i, i + 1);   // Even length
        }

        return s.substring(start, start + maxLength);
    }

    private void expandFromCenter(String s, int left, int right) {

        while (left >= 0 &&
               right < s.length() &&
               s.charAt(left) == s.charAt(right)) {

            left--;
            right++;
        }

        int length = right - left - 1;

        if (length > maxLength) {
            maxLength = length;
            start = left + 1;
        }
    }
}