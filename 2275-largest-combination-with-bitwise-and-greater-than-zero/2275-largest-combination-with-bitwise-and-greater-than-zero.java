public class Solution {

    public int largestCombination(int[] candidates) {
        int maxCombination = 0;

        for (int bit = 0; bit < 32; bit++) {
            int count = 0;

            for (int num : candidates) {
                if ((num & (1 << bit)) != 0) {
                    count++;
                }
            }

            maxCombination = Math.max(maxCombination, count);
        }

        return maxCombination;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] candidates = {16, 17, 71, 62, 12, 24, 14};
        System.out.println("Largest combination size with bitwise AND > 0: " + solution.largestCombination(candidates));
    }
}
