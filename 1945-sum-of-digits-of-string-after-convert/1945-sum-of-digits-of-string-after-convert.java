class Solution {
    public int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()){
            sb.append(ch-96);
        }
        while(k>0){
            int sum=0;
            for(int i=0;i<sb.length();i++){ 
                sum += (sb.charAt(i) - '0');
            }
            k--;
            sb = new StringBuilder(String.valueOf(sum)); 
        }
        return Integer.parseInt(sb.toString());
    }
}
