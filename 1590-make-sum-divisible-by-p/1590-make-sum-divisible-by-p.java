import java.util.HashMap;

public class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        long totalSum = 0;
        
        // Calculate the total sum of the array
        for (int num : nums) {
            totalSum += num;
        }

        // We want the remaining sum to be divisible by p
        int targetMod = (int) (totalSum % p);
        if (targetMod == 0) {
            return 0;  // The total sum is already divisible by p
        }

        // HashMap to store the prefix sum mod p and its index
        HashMap<Integer, Integer> prefixModMap = new HashMap<>();
        prefixModMap.put(0, -1);  // Base case for when the prefix sum itself is divisible by p
        
        int minLen = n;
        long prefixSum = 0;

        for (int i = 0; i < n; i++) {
            // Calculate the current prefix sum
            prefixSum += nums[i];
            int currentMod = (int) (prefixSum % p);

            // We want (prefixSum - some previous prefixSum) % p == targetMod
            int neededMod = (currentMod - targetMod + p) % p;

            // If we have seen a prefix sum mod that matches neededMod, update minLen
            if (prefixModMap.containsKey(neededMod)) {
                minLen = Math.min(minLen, i - prefixModMap.get(neededMod));
            }

            // Store the current prefix sum mod and its index
            prefixModMap.put(currentMod, i);
        }

        // If we didn't find a valid subarray, return -1
        return minLen == n ? -1 : minLen;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1:
        int[] nums1 = {3, 1, 4, 2};
        int p1 = 6;
        System.out.println(solution.minSubarray(nums1, p1));  // Output: 1

        // Example 2:
        int[] nums2 = {6, 3, 5, 2};
        int p2 = 9;
        System.out.println(solution.minSubarray(nums2, p2));  // Output: 2

        // Example 3:
        int[] nums3 = {1, 2, 3};
        int p3 = 3;
        System.out.println(solution.minSubarray(nums3, p3));  // Output: 0

        // Example 4:
        int[] nums4 = {1, 2, 3};
        int p4 = 7;
        System.out.println(solution.minSubarray(nums4, p4));  // Output: -1
    }
}
