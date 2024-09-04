class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
      
        int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } }; //constant
        int[] curPos = { 0, 0 };
        int res = 0;
        int curDir = 0; 
        HashMap<Integer,HashSet<Integer>> obstacleMap = new HashMap<>();
        for (int[] obstacle : obstacles) { 
            if(!obstacleMap.containsKey(obstacle[0])){
                obstacleMap.put(obstacle[0],new HashSet<>());
            }
            obstacleMap.get(obstacle[0]).add(obstacle[1]);
        }

        for (int command : commands) {
            if (command == -1) {
                
                curDir = (curDir + 1) % 4;
                continue;
            }
            if (command == -2) {
               
                curDir = (curDir - 1);
                if(curDir==-1){
                    curDir=3;
                }
                continue;
            }

           
            int[] direction = directions[curDir];
            for (int step = 0; step < command; step++) { //9
                int nextX = curPos[0] + direction[0];
                int nextY = curPos[1] + direction[1];
                if(obstacleMap.containsKey(nextX) && obstacleMap.get(nextX).contains(nextY)){
                    break;
                }
                curPos[0] = nextX;
                curPos[1] = nextY;
            }

            res = Math.max(res,curPos[0] * curPos[0] +curPos[1] * curPos[1]);
        }
        return res;
    }
}