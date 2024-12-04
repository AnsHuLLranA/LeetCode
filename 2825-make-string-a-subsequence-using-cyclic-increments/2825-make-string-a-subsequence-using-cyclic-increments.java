class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int str1Index = 0, str2Index = 0;
        int lengthStr1 = str1.length(), lengthStr2 = str2.length();

        while (str1Index < lengthStr1 && str2Index < lengthStr2) {
            char str1Char = str1.charAt(str1Index);
            char str2Char = str2.charAt(str2Index);

            // Check if characters match or can match via increment
            if (str1Char == str2Char || getNextChar(str1Char) == str2Char) {
                str2Index++; // Move to the next character in str2
            }
            str1Index++; // Always move to the next character in str1
        }

        // Check if all characters of str2 are matched
        return str2Index == lengthStr2;
    }

    // Helper function to get the next character cyclically
    private char getNextChar(char str1Char) {
        return str1Char == 'z' ? 'a' : (char) (str1Char + 1);
    }
}
