public class Solution {
    public int longestSubarray(int[] nums) {
        int maxVal = 0;
           for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }
        
       
        int maxLength = 0;
        int currentLength = 0;
        
        for (int num : nums) {
            if (num == maxVal) {
                
                currentLength++;
            } else {
                
                currentLength = 0;
            }
            
            maxLength = Math.max(maxLength, currentLength);
        }
        
        return maxLength;
    }
}
