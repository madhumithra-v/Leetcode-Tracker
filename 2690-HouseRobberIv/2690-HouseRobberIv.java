// Last updated: 7/9/2026, 3:06:34 PM
class Solution {

    public int minCapability(int[] nums, int k) {

        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;

        for (int num : nums) {
            left = Math.min(left, num);
            right = Math.max(right, num);
        }

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (canRob(nums, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean canRob(int[] nums, int k, int cap) {

        int count = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] <= cap) {
                count++;
                i++;
            }
        }

        return count >= k;
    }
}