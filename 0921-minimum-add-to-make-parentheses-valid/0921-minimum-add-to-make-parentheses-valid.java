class Solution {
    public int minAddToMakeValid(String s) {
        int open = 0, close=0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '('){
                open++;
            } else {
                if(open<=0) {
                    close++; 
                } else {
                    open--; 
                }
            }
        }
        return (open+close); 
    }
}
      