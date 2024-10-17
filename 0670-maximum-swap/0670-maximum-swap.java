public class Solution {

    public static int maximumSwap(int num) {
        // Convert the number to a char array of digits
        char[] digits = Integer.toString(num).toCharArray();

        // Track the last occurrence of each digit (0-9)
        int[] lastIndex = new int[10];
        for (int i = 0; i < digits.length; i++) {
            lastIndex[digits[i] - '0'] = i;
        }

        // Try to swap from left to right
        for (int i = 0; i < digits.length; i++) {
            // Check for a larger digit from 9 down to the current digit
            for (int d = 9; d > digits[i] - '0'; d--) {
                if (lastIndex[d] > i) {
                    // If a larger digit exists later, swap them
                    char temp = digits[i];
                    digits[i] = digits[lastIndex[d]];
                    digits[lastIndex[d]] = temp;

                    // Return the new number as an integer
                    return Integer.parseInt(new String(digits));
                }
            }
        }

        // If no swap is done, return the original number
        return num;
    }

    public static void main(String[] args) {
        // Test case
        int num = 2736;   // Output: 7236
        System.out.println(maximumSwap(num));
    }
}
