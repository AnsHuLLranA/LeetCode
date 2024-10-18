class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int targetOr = 0;
        for(int num : nums){
            targetOr |= num;
        }
        
        Integer dp[][] = new Integer [nums.length][targetOr+1];
        return recur(0,nums,0,targetOr,dp);
    }
    
public int recur(int index, int nums[], int curOr, int targetOr,Integer dp[][]){        
        if(index == nums.length){
            return (curOr == targetOr)?1:0;
        }
        if(dp[index][curOr]!=null){
            return dp[index][curOr];
        }
        int pickCount = recur(index+1, nums, curOr | nums[index], targetOr,dp);
        
        int noPickCount = recur(index+1, nums, curOr, targetOr,dp);
        
        return dp[index][curOr] = pickCount + noPickCount;
    }
}