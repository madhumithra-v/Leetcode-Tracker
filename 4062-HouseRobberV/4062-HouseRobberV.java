// Last updated: 7/9/2026, 3:06:22 PM
class Solution {
    public long rob(int[] nums, int[] colors) {

        long notRob = 0;
        long rob = nums[0];

        for (int i = 1; i < nums.length; i++) {

            if (colors[i] == colors[i - 1]) {

                long newRob = notRob + nums[i];
                notRob = Math.max(notRob, rob);
                rob = newRob;

            } else {

                long best = Math.max(notRob, rob);
                long newRob = best + nums[i];

                notRob = best;
                rob = newRob;
            }
        }

        return Math.max(notRob, rob);
    }
}