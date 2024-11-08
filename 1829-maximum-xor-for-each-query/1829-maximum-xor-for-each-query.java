import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int maxK = (1 << maximumBit) - 1;  
        int currentXor = 0;

        for (int num : nums) {
            currentXor ^= num;
        }

        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            answer[i] = currentXor ^ maxK;

            currentXor ^= nums[n - 1 - i];
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {0, 1, 1, 3};
        int maximumBit = 2;
        int[] result = solution.getMaximumXor(nums, maximumBit);
        
        for (int res : result) {
            System.out.print(res + " ");
        }
    }
}
