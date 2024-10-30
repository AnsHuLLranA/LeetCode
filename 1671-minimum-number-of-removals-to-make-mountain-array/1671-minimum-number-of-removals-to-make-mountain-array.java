import java.util.Arrays;

public class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        
        // Step 1: Calculate LIS ending at each index
        int[] lis = new int[n];
        Arrays.fill(lis, 1);
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
        }
        
        // Step 2: Calculate LDS starting from each index
        int[] lds = new int[n];
        Arrays.fill(lds, 1);
        
        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (nums[i] > nums[j]) {
                    lds[i] = Math.max(lds[i], lds[j] + 1);
                }
            }
        }
        
        // Step 3: Calculate the maximum length of a mountain array
        int maxMountainLength = 0;
        
        for (int i = 1; i < n - 1; i++) {
            if (lis[i] > 1 && lds[i] > 1) {  // Only consider valid peaks
                maxMountainLength = Math.max(maxMountainLength, lis[i] + lds[i] - 1);
            }
        }
        
        // Step 4: Calculate the minimum number of removals
        return n - maxMountainLength;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {1, 3, 1};
        System.out.println("Minimum removals: " + solution.minimumMountainRemovals(nums1)); // Output: 0

        int[] nums2 = {2, 1, 1, 5, 6, 2, 3, 1};
        System.out.println("Minimum removals: " + solution.minimumMountainRemovals(nums2)); // Output: 3
    }
}
