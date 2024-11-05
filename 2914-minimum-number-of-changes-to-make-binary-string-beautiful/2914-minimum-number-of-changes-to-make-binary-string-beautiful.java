class Solution {
    public int minChanges(String s) {
        int changes = 0;
        char currChar = s.charAt(0);
        int count = 0;

        for (char ch : s.toCharArray()) {
            if (ch == currChar) {
                count++;
                continue;
            }
            if (count % 2 == 1) {
                changes++;
                count = 0;
            } else {
                count = 1;
            }
            currChar = ch;
        }

        return changes;
    }
}
