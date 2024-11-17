class Solution {

    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;

        int shortestSubarrayLength = Integer.MAX_VALUE;

        long cumulativeSum = 0;

        PriorityQueue<Pair<Long, Integer>> prefixSumHeap = new PriorityQueue<>(
            (a, b) -> Long.compare(a.getKey(), b.getKey())
        );
        for (int i = 0; i < n; i++) {
            cumulativeSum += nums[i];
            if (cumulativeSum >= k) {
                shortestSubarrayLength = Math.min(
                    shortestSubarrayLength,
                    i + 1
                );
            }

            while (
                !prefixSumHeap.isEmpty() &&
                cumulativeSum - prefixSumHeap.peek().getKey() >= k
            ) {
                shortestSubarrayLength = Math.min(
                    shortestSubarrayLength,
                    i - prefixSumHeap.poll().getValue()
                );
            }

            prefixSumHeap.offer(new Pair<>(cumulativeSum, i));
        }

        return shortestSubarrayLength == Integer.MAX_VALUE
            ? -1
            : shortestSubarrayLength;
    }
}