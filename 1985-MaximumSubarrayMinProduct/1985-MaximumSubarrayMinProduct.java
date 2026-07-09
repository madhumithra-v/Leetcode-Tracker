// Last updated: 7/9/2026, 3:06:38 PM
import java.util.*;

class Solution {

    public int maxSumMinProduct(int[] nums) {

        int n = nums.length;

        long[] prefix = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> st = new Stack<>();

        // left smaller element
        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                st.pop();
            }

            left[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();

        // right smaller element
        for (int i = n - 1; i >= 0; i--) {

            while (!st.isEmpty() && nums[st.peek()] > nums[i]) {
                st.pop();
            }

            right[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        long ans = 0;

        for (int i = 0; i < n; i++) {

            int l = left[i];
            int r = right[i];

            long sum = prefix[r] - prefix[l + 1];

            ans = Math.max(ans, sum * nums[i]);
        }

        return (int)(ans % 1_000_000_007);
    }
}