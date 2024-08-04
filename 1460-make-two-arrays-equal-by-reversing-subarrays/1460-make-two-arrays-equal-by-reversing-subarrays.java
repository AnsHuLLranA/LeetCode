class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        int freq[] = new int[1001]; 
        for(int element : target){
            freq[element]++;
        }
        for(int element : arr){
            freq[element]--;
        }
        for(int element : freq){
            if(element!=0){
                return false;
            }
        }
        return true;
    }
}