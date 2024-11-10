class Solution {

    public int minimumSubarrayLength(int[] nums, int k) {
        int left = 1;
        int right = nums.length;
        int minLength = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (hasValidSubarray(nums, k, mid)) {
                minLength = mid;
                right = mid - 1; 
            } else {
                left = mid + 1; 
            }
        }

        return minLength;
    }

    private boolean hasValidSubarray(
        int[] nums,
        int targetSum,
        int windowSize
    ) {
        int arrayLength = nums.length;
        int[] bitCounts = new int[32]; 
        for (int right = 0; right < arrayLength; right++) {
            updateBitCounts(bitCounts, nums[right], 1);

            if (right >= windowSize) {
                updateBitCounts(bitCounts, nums[right - windowSize], -1);
            }

            if (
                right >= windowSize - 1 &&
                convertBitCountsToNumber(bitCounts) >= targetSum
            ) {
                return true;
            }
        }
        return false;
    }

    private void updateBitCounts(int[] bitCounts, int number, int delta) {
        for (int bitPosition = 0; bitPosition < 32; bitPosition++) {
            if (((number >> bitPosition) & 1) != 0) {
                bitCounts[bitPosition] += delta;
            }
        }
    }

    private int convertBitCountsToNumber(int[] bitCounts) {
        int number = 0;
        for (int bitPosition = 0; bitPosition < 32; bitPosition++) {
            if (bitCounts[bitPosition] != 0) {
                number |= 1 << bitPosition;
            }
        }
        return number;
    }
}