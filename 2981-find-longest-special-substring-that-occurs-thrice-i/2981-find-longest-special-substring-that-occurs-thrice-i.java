class Solution {

    public int maximumLength(String s) {
        // Create a HashMap to store the count of all substrings
        HashMap<String, Integer> count = new HashMap<>();

        // Iterate through the string to create substrings
        for (int start = 0; start < s.length(); start++) {
            StringBuilder currString = new StringBuilder();

            for (int end = start; end < s.length(); end++) {
                // If the string is empty, or the current character is equal to
                // the previously added character, then add it to the HashMap.
                // Otherwise, break the iteration.
                if (
                    currString.length() == 0 ||
                    currString.charAt(currString.length() - 1) == s.charAt(end)
                ) {
                    currString.append(s.charAt(end)); // Use append instead of concatenation
                    count.put(
                        currString.toString(),
                        count.getOrDefault(currString.toString(), 0) + 1
                    );
                } else {
                    break;
                }
            }
        }

        // Create a variable ans to store the longest length of substring with
        // frequency at least 3.
        int ans = 0;
        for (String str : count.keySet()) {
            if (count.get(str) >= 3 && str.length() > ans) ans = str.length();
        }

        if (ans == 0) return -1;
        return ans;
    }
}