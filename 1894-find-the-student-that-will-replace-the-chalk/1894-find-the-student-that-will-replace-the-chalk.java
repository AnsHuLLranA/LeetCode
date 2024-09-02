class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long sum=0;
        for(int i=0;i<chalk.length;i++){
            sum+=chalk[i];
        }
        int remainingChalks = (int)(k % sum);
        for(int i=0;i<chalk.length;i++){
            if(remainingChalks < chalk[i]){
                return i;
            }
            remainingChalks -= chalk[i];
        }
        return -1;
    }
}
