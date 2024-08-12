import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public boolean isTransformable(String s, String t) {
        int n = s.length();
        // Create an array of queues where each queue stores the indices of the digit i in s
        Queue<Integer>[] positions = new LinkedList[10];
        for (int i = 0; i < 10; ++i) {
            positions[i] = new LinkedList<>();
        }
        for (int i = 0; i < n; ++i) {
            positions[s.charAt(i) - '0'].offer(i);
        }

        // Iterate over t and try to match it with s using the positions array
        for (int i = 0; i < n; ++i) {
            int digit = t.charAt(i) - '0';
            // If there's no such digit in s or it's blocked by a smaller digit, return false
            if (positions[digit].isEmpty()) {
                return false;
            }
            for (int j = 0; j < digit; ++j) {
                if (!positions[j].isEmpty() && positions[j].peek() < positions[digit].peek()) {
                    return false;
                }
            }
            // Remove the used position for this digit
            positions[digit].poll();
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        String s1 = "84532";
        String t1 = "34852";
        System.out.println(solution.isTransformable(s1, t1)); // Output: true

        String s2 = "34521";
        String t2 = "23415";
        System.out.println(solution.isTransformable(s2, t2)); // Output: true

        String s3 = "12345";
        String t3 = "12435";
        System.out.println(solution.isTransformable(s3, t3)); // Output: false
    }
}
