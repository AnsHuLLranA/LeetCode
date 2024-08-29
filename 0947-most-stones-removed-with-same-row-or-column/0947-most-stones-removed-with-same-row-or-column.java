class Solution {
    private int n;
    
    private void dfs(int[][] stones, int index, boolean[] visited) {
        visited[index] = true;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i] &&
                (stones[i][0] == stones[index][0] || stones[i][1] == stones[index][1])) {
                dfs(stones, i, visited);
            }
        }
    }
    
    public int removeStones(int[][] stones) {
        n = stones.length;
        boolean[] visited = new boolean[n];
        
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            dfs(stones, i, visited);
            count++;
        }
        
        return n - count;
    }
}