class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<>(){
            @Override
            public int compare(int[] a1, int[] a2){
                if(a1[0] == a2[0])
                    return a2[1] - a1[1];
                return a1[0]-a2[0];
            }
        });
        
        int right = intervals[0][1];
        int cnt = 1;
        
        for(int i=1;i<intervals.length;i++){
            // overlaping
            if(right>=intervals[i][1]){
                continue;
            }else{
                right = intervals[i][1];
                cnt++;
            }
        }
        
        return cnt;
    }
}