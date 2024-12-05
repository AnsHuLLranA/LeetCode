class Solution {
    public boolean canChange(String start, String target) {
        // Remove all underscores and check if the remaining characters match
        if (!start.replace("_", "").equals(target.replace("_", ""))) {
            return false;
        }

        int startIndex = 0, targetIndex = 0;
        int n = start.length();

        while (startIndex < n && targetIndex < n) {
            // Skip underscores in both strings
            while (startIndex < n && start.charAt(startIndex) == '_') {
                startIndex++;
            }
            while (targetIndex < n && target.charAt(targetIndex) == '_') {
                targetIndex++;
            }

            // If one pointer reaches the end, both must reach the end
            if (startIndex == n || targetIndex == n) {
                return startIndex == targetIndex;
            }

            // Check if characters at the current indices match
            if (start.charAt(startIndex) != target.charAt(targetIndex)) {
                return false;
            }

            // Check movement constraints
            if (start.charAt(startIndex) == 'L' && startIndex < targetIndex) {
                return false; // 'L' can only move left
            }
            if (start.charAt(startIndex) == 'R' && startIndex > targetIndex) {
                return false; // 'R' can only move right
            }

            // Move both pointers
            startIndex++;
            targetIndex++;
        }

        return true;
    }
}
