import java.util.*;

public class Solution {
    public int minGroups(int[][] intervals) {
        // List to store all the events (start and end points)
        List<int[]> events = new ArrayList<>();
        
        for (int[] interval : intervals) {
            // Start of interval
            events.add(new int[]{interval[0], 1});
            // End of interval (+1 because end is inclusive)
            events.add(new int[]{interval[1] + 1, -1});
        }
        
        // Sort events: first by time, then by type (-1 before +1 when times are the same)
        Collections.sort(events, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });
        
        int activeIntervals = 0;
        int maxGroups = 0;
        
        // Iterate over all events
        for (int[] event : events) {
            activeIntervals += event[1]; // Add 1 for start, subtract 1 for end
            maxGroups = Math.max(maxGroups, activeIntervals); // Track the maximum
        }
        
        return maxGroups;
    }
}
