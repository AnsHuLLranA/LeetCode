class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        int curNum=1;
        for(int i=1;i<=n;i++){
            res.add(curNum);
            if(curNum*10 <= n){
                curNum*=10;
            }else{
                while(curNum%10 == 9 || curNum==n){
                    curNum/=10;
                }
                curNum+=1;
            }
        }
        return res;
    }
}