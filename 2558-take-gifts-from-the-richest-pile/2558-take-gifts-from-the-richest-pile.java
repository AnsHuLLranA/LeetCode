public class Solution {

    public long pickGifts(int[] gifts, int k) {
        int n = gifts.length;

        // Perform the operation k times
        for (int i = 0; i < k; i++) {
            // Initialize the index of the richest pile (maximum element)
            int richestPileIndex = 0;

            // Iterate through the array to find the index of the maximum element
            for (
                int currentPileIndex = 0;
                currentPileIndex < n;
                currentPileIndex++
            ) {
                // If we find a new maximum, update the index
                if (gifts[richestPileIndex] < gifts[currentPileIndex]) {
                    richestPileIndex = currentPileIndex;
                }
            }

            // Replace the richest pile with the floor of its square root
            gifts[richestPileIndex] = (int) Math.floor(
                Math.sqrt(gifts[richestPileIndex])
            );
        }

        // Calculate the sum of the remaining gifts in the array
        long numberOfRemainingGifts = Arrays.stream(gifts)
            .mapToLong(gift -> gift) // Map to long to avoid overflow
            .sum();

        return numberOfRemainingGifts;
    }
}