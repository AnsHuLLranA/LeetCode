import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public void wiggleSort(int[] nums) {
        // Step 1
        Arrays.sort(nums);
        // Step 2
        int n = nums.length;
        int[] res = new int[n];
        int i = 1;
        int j = n - 1;
        while (i < n) {
            res[i] = nums[j];
            i += 2;
            j--;
        }
        i = 0;
        while (i < n) {
            res[i] = nums[j];
            i += 2;
            j--;
        }
        // Step 3
        for (i = 0; i < n; i++) {
            nums[i] = res[i];
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        new Solution().wiggleSort(arr);  // Corrected method name
        scn.close();
    }
}
