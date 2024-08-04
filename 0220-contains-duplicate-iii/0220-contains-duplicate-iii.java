class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> tset = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long justSmaller = tset.floor((long) nums[i]);
            Long justLarger = tset.ceiling((long) nums[i]);

            if (justSmaller != null && nums[i] - justSmaller <= t) {
                return true;
            }

            if (justLarger != null && justLarger - nums[i] <= t) {
                return true;
            }

            tset.add((long) nums[i]);

            if (tset.size() > k) {
                tset.remove((long) nums[i - k]);
            }
        }

        return false;
    }
}