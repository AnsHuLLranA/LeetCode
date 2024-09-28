import java.util.*;

class Solution {
    private Map<Integer, Integer> map;  // Maps blacklisted numbers to valid ones
    private int range;  // Represents the size of the valid range
    private Random random;

    // Constructor
    public Solution(int n, int[] blacklist) {
        map = new HashMap<>();
        random = new Random();
        
        // Valid range is [0, n - blacklist.length) for picking numbers
        range = n - blacklist.length;
        
        // Set to hold blacklisted numbers in the upper part of the range [range, n-1]
        Set<Integer> blacklistSet = new HashSet<>();
        for (int b : blacklist) {
            if (b >= range) {
                blacklistSet.add(b);
            }
        }

        // We need to map blacklisted numbers < range to valid numbers in [range, n-1]
        int last = range;  // Pointer for valid numbers in the upper part
        for (int b : blacklist) {
            if (b < range) {
                // Find the next valid number >= range that is not blacklisted
                while (blacklistSet.contains(last)) {
                    last++;
                }
                // Map the blacklisted number to a valid number
                map.put(b, last);
                last++;
            }
        }
    }

    // Picks a random number in the range [0, n - blacklist.length)
    public int pick() {
        // Generate a random number in [0, range-1]
        int r = random.nextInt(range);
        
        // If this number is blacklisted, return the mapped value
        return map.getOrDefault(r, r);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */
