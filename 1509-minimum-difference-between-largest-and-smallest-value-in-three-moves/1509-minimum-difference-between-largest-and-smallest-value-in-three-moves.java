import java.util.Arrays;

class Solution {
    public int minDifference(int[] nums) {
        Arrays.sort(nums);

        int minv = Integer.MAX_VALUE;
        int n = nums.length;
        if (n <= 4) return 0;

        // Remove 3 from the right
        minv = Math.min(minv, nums[n - 4] - nums[0]);

        // Remove 3 from the left
        minv = Math.min(minv, nums[n - 1] - nums[3]);

        // Remove 2 from the left and 1 from the right
        minv = Math.min(minv, nums[n - 3] - nums[1]);

        // Remove 1 from the left and 2 from the right
        minv = Math.min(minv, nums[n - 2] - nums[2]);

        return minv;
    }
}
