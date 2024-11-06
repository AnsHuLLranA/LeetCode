public class Solution {
    public boolean canSortArray(int[] nums) {
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (Integer.bitCount(nums[j]) == Integer.bitCount(nums[j + 1]) && nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        
        int[] sortedNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sortedNums);
        
        return Arrays.equals(nums, sortedNums);
    }
}
