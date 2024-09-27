class MyCalendarTwo {
    List<int[]> bookings;
    TreeMap<Integer,Integer> overlappedMap;
    public MyCalendarTwo() {
        bookings = new ArrayList<>();
        overlappedMap = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
      
        Integer prevVal = overlappedMap.lowerKey(end);
        if(prevVal!=null && start <= overlappedMap.get(prevVal)-1){
            return false;
        }
        
        for(int booking[] : bookings){
            
            int commStart = Math.max(booking[0],start);
            int commEnd = Math.min(booking[1],end);
            if(commStart<commEnd){
                overlappedMap.put(commStart,commEnd);
            }
        }
        bookings.add(new int[]{start,end});
        return true;
    }
}
