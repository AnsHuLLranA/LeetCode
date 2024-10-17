public class Solution {

    public static int maximumSwap(int num) {
        char[] digits = Integer.toString(num).toCharArray();

        int[] lastIndex = new int[10];
        for (int i = 0; i < digits.length; i++) {
            lastIndex[digits[i] - '0'] = i;
        }

        for (int i = 0; i < digits.length; i++) {
            for (int d = 9; d > digits[i] - '0'; d--) {
                if (lastIndex[d] > i) {
                    char temp = digits[i];
                    digits[i] = digits[lastIndex[d]];
                    digits[lastIndex[d]] = temp;

                    return Integer.parseInt(new String(digits));
                }
            }
        }

        return num;
    }

    public static void main(String[] args) {
        int num = 2736;   
        System.out.println(maximumSwap(num));
    }
}
