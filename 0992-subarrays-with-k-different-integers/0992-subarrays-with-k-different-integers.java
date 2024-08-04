import java.util.HashMap;
import java.util.Map;

public class Solution {
    private int countSubarraysWithAtMostKDistinct(int[] A, int K) {
        int n = A.length;
        int total = 0;
        int distinctCount = 0;
        int j = 0;
        Map<Integer, Integer> count = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            count.put(A[i], count.getOrDefault(A[i], 0) + 1);
            if (count.get(A[i]) == 1) {
                distinctCount++;
            }
            
            while (distinctCount > K) {
                count.put(A[j], count.get(A[j]) - 1);
                if (count.get(A[j]) == 0) {
                    distinctCount--;
                }
                j++;
            }
            
            total += i - j + 1;
        }
        
        return total;
    }
    
    public int subarraysWithKDistinct(int[] A, int K) {
        return countSubarraysWithAtMostKDistinct(A, K) - countSubarraysWithAtMostKDistinct(A, K - 1);
    }
}
