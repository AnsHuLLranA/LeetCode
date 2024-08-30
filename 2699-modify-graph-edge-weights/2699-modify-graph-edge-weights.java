class Solution {
    long INF = 1000000000000000l;
    int large = 1000000000;
    
    List<List<Pair<Integer, Integer>>> adj = new ArrayList<>();
    
    private void createAdjacencyList(int n, int[][] edges){
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge: edges){
            if(edge[2] == -1){
                continue;
            }
            int n1 = edge[0];
            int n2 = edge[1];
            int wt = edge[2];
            adj.get(n1).add(new Pair(n2,wt));
            adj.get(n2).add(new Pair(n1,wt));
        }
    }
    public int[][] modifiedGraphEdges(int n, int[][] edges, int src, int dest, int target) {
        
        createAdjacencyList(n, edges);
        long[] dist = new long[n];
        Arrays.fill(dist, INF);
        
        Queue<Integer> q = new LinkedList<>();
        dist[src] = 0;
        q.add(src);
        while(!q.isEmpty()) {
            int u = q.peek();
            q.remove();
            for(Pair<Integer, Integer> pair : adj.get(u)) {
                int nxt = pair.getKey(), wt = pair.getValue();
                if(dist[nxt] > dist[u] + wt) {
                    dist[nxt] = dist[u] + wt;
                    q.add(nxt);
                }
            }
        }
              
        if(dist[dest] < target) {
            return new int[][]{};
        }
        
        if(dist[dest] == target) {
            for(int[] edge : edges) {
                if(edge[2] == -1) edge[2] = large;
            }
            return edges;
        }
        
        
        for(int i=0;i<edges.length;i++){
            int[] edge = edges[i];
            int u = edge[0], v = edge[1], wt = edge[2];
            if(wt == -1){
                edge[2] = 1;
                adj.get(u).add(new Pair(v,1));
                adj.get(v).add(new Pair(u,1));
                
                q = new LinkedList<>();
                Arrays.fill(dist, INF);
                dist[src] = 0;
                q.add(src);
                while(!q.isEmpty()){
                    u = q.peek();
                    q.remove();
                    for(Pair<Integer, Integer> pair : adj.get(u)) {
                        int nxt = pair.getKey(); wt = pair.getValue();
                        if(dist[nxt] > dist[u] + wt) {
                            dist[nxt] = dist[u] + wt;
                            q.add(nxt);
                        }
                    }
                }
                
                if(dist[dest] <= target) {
                    edge[2] += (target - dist[dest]);
                    for(int j=i+1; j<edges.length; j++){
                        if(edges[j][2] == -1) {
                           edges[j][2] = large; 
                        }
                    }
                    return edges;
                }
            }
        }
        return new int[][]{};
    }
}