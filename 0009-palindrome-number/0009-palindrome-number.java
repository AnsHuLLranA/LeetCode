class Solution {
    public boolean isPalindrome(int x) {
        int temp=x, digit=0, res=0;
        if(x<0)
            return false;
        while(x!=0)
        {
            digit=x%10;
            x/=10;
            res=res*10+digit;
        }
        if(temp==res)
            return true;
        return false;
        
    }
}