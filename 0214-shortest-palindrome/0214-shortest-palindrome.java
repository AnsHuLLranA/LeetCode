public class Solution {
    public String shortestPalindrome(String s) {
        String rev_s = new StringBuilder(s).reverse().toString();
        String combined = s + "#" + rev_s;

        int[] kmpTable = computeKMP(combined);

        int charactersToAdd = s.length() - kmpTable[kmpTable.length - 1];

        return rev_s.substring(0, charactersToAdd) + s;
    }

    private int[] computeKMP(String s) {
        int[] kmpTable = new int[s.length()];
        int j = 0;

        for (int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = kmpTable[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            kmpTable[i] = j;
        }

        return kmpTable;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "aacecaaa";
        System.out.println("Shortest Palindrome: " + solution.shortestPalindrome(s)); // Output: aaacecaaa

        s = "abcd";
        System.out.println("Shortest Palindrome: " + solution.shortestPalindrome(s)); // Output: dcbabcd
    }
}
