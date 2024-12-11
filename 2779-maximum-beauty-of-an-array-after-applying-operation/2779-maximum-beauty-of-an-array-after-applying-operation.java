class Solution {

    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int maxBeauty = 0;

        for (int i = 0; i < nums.length; i++) {

            int upperBound = findUpperBound(nums, nums[i] + 2 * k);

            maxBeauty = Math.max(maxBeauty, upperBound - i + 1);
        }
        return maxBeauty;
    }


    private int findUpperBound(int[] arr, int val) {
        int low = 0, high = arr.length - 1, result = 0;


        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= val) {
                result = mid; 
                low = mid + 1;
            } else {
                high = mid - 1; 
            }
        }
        return result;
    }
}