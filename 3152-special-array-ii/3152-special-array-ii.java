class Solution {

    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        boolean[] ans = new boolean[queries.length];
        ArrayList<Integer> violatingIndices = new ArrayList<>();

        for (int i = 1; i < nums.length; i++) {
            // same parity, found violating index
            if (nums[i] % 2 == nums[i - 1] % 2) {
                violatingIndices.add(i);
            }
        }

        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int start = query[0];
            int end = query[1];

            boolean foundViolatingIndex = binarySearch(
                start + 1,
                end,
                violatingIndices
            );

            if (foundViolatingIndex) {
                ans[i] = false;
            } else {
                ans[i] = true;
            }
        }

        return ans;
    }

    private boolean binarySearch(
        int start,
        int end,
        ArrayList<Integer> violatingIndices
    ) {
        int left = 0;
        int right = violatingIndices.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int violatingIndex = violatingIndices.get(mid);

            if (violatingIndex < start) {
                // check right half
                left = mid + 1;
            } else if (violatingIndex > end) {
                // check left half
                right = mid - 1;
            } else {
                // violatingIndex falls in between start and end
                return true;
            }
        }

        return false;
    }
}