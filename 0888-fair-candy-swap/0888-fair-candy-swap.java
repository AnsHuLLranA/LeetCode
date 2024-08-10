import java.util.*;

class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {
        int aSum = 0, bSum = 0;
        
        for (int x : A) aSum += x;
        for (int x : B) bSum += x;
        
        int diff = (aSum - bSum) / 2;
        
        Set<Integer> setB = new HashSet<>();
        for (int x : B) setB.add(x);
                for (int x : A) {
            if (setB.contains(x - diff)) {
                return new int[]{x, x - diff};
            }
        }
        
        return new int[0];
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] A = {1, 1};
        int[] B = {2, 2};
        int[] result = sol.fairCandySwap(A, B);
        System.out.println(Arrays.toString(result));
    }
}
