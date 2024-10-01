import java.util.Arrays;

class Solution {
    public int numSubseq(int[] nums, int target) {
        int M = 1_000_000_007;
        int n = nums.length;
        
        Arrays.sort(nums);
        
        // Precompute powers of 2
        int[] power = new int[n];
        power[0] = 1;
        for (int i = 1; i < n; i++) {
            power[i] = (power[i - 1] * 2) % M;
        }
        
        int l = 0, r = n - 1;
        int result = 0;

        // Two-pointer approach
        while (l <= r) {
            if (nums[l] + nums[r] <= target) {
                result = (result + power[r - l]) % M;
                l++;
            } else {
                r--;
            }
        }
        
        return result;
    }
}
