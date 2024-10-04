class Solution {
    public long dividePlayers(int[] skill) {
        int n = skill.length;
        int teams = n/2;
        int totalSum=0;
        int freqMap[] = new int[1001];
        for(int element : skill){
            freqMap[element]++;
            totalSum += element;
        }
        if(totalSum % teams !=0 ){
            return -1;
        }
        int targetPoints = totalSum / teams;
        long res = 0;
        for(int element : skill){
            if(freqMap[element]==0){
                continue;
            }
            freqMap[element]--;
            int partner = targetPoints - element;
            if(freqMap[partner]==0){
                return -1;
            }
            freqMap[partner]--;
            res = res + ((long)element * (long)partner);
        }
        return res;
    }
}