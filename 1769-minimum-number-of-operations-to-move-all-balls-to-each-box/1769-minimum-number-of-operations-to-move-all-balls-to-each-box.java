class Solution {
    public int[] minOperations(String boxes) {
        int[] result = new int[boxes.length()];
        int travel = 0;
        int ones = 0;
        for(int i = 0; i < boxes.length(); i++){
            travel += ones;
            result[i] += travel;
            if(boxes.charAt(i) == '1') ones++;
        }
        travel = 0;
        ones = 0;
        for(int i = boxes.length() -1; i>=0; i--){
            travel += ones;
            result[i] +=travel;
            if(boxes.charAt(i) == '1') ones++;
        }
        return result;
    }
}