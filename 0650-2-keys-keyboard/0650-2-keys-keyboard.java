class Solution {
    private int util(int currLenOfAs, int pastLenOfAs, int n) {
        if (currLenOfAs == n) {
            return 0;
            
            
        }

        if (currLenOfAs > n) {
            return 1000; 
            
            
        }

        
        int res1 = 2 + util(currLenOfAs * 2, currLenOfAs, n);


        int res2 = 1 + util(currLenOfAs + pastLenOfAs, pastLenOfAs, n);

        
        return Math.min(res1, res2);
    }

    
    public int minSteps(int n) {
        if (n == 1) {
            return 0;
        }
        

        return 1 + util(1, 1, n);
    }
}
