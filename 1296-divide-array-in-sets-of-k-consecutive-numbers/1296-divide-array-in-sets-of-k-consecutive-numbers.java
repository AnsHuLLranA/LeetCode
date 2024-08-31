class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        if (nums.length % k != 0) return false;
        
        Map<Integer, Integer> map = new TreeMap<>();
        for (Integer num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        Queue<Integer> q = new LinkedList<>();
        int lastSeenValue = -1;
        int groupInProgress = 0;
        
        for (Integer key : map.keySet()) {
            if (groupInProgress > 0 
                && key > lastSeenValue + 1 
                    || groupInProgress > map.get(key)) {
                return false;
            }
            
            q.add(map.get(key) - groupInProgress);
            lastSeenValue = key;
            groupInProgress = map.get(key);
            
            if (q.size() == k) {
                groupInProgress = groupInProgress - q.poll();
            }
        }
        
        return groupInProgress == 0;
    }
}



