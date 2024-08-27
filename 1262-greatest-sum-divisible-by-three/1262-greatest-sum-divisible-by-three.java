class Solution {
    public int maxSumDivThree(int[] nums) {
        int dp1[][] = new int[3][nums.length];
        dp1[nums[0]%3][0] = nums[0];

        for(int i=1;i<nums.length;i++)
        {
            int index1 = (nums[i] + dp1[0][i-1])%3;
            int index2 = (nums[i] + dp1[1][i-1])%3;
            int index3 = (nums[i] + dp1[2][i-1])%3;

            dp1[index1][i] = Math.max(dp1[index1][i],dp1[0][i-1] + nums[i]);
            dp1[index2][i] = Math.max(dp1[index2][i],dp1[1][i-1] + nums[i]);
            dp1[index3][i] = Math.max(dp1[index3][i],dp1[2][i-1] + nums[i]);

            dp1[0][i] = Math.max(dp1[0][i-1],dp1[0][i]);
            dp1[1][i] = Math.max(dp1[1][i-1],dp1[1][i]);
            dp1[2][i] = Math.max(dp1[2][i-1],dp1[2][i]);
        }
    
        return dp1[0][nums.length-1];
    }
}