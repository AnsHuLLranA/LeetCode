class Solution {

    public int maxCount(int[] banned, int n, int maxSum) {
        Arrays.sort(banned);

        int count = 0;

        for (int num = 1; num <= n; num++) {
            if (customBinarySearch(banned, num)) continue;

            maxSum -= num;

            if (maxSum < 0) break;

            count++;
        }
        return count;
    }

    private boolean customBinarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) return true;

            if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}