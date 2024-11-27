class Solution {

    private int bfs(int n, List<List<Integer>> adjList) {
        boolean[] visited = new boolean[n];
        Queue<Integer> nodeQueue = new LinkedList<>();

        nodeQueue.add(0);
        visited[0] = true;

        int currentLayerNodeCount = 1;
        int nextLayerNodeCount = 0;
        int layersExplored = 0;

        while (!nodeQueue.isEmpty()) {
            for (int i = 0; i < currentLayerNodeCount; i++) {
                int currentNode = nodeQueue.poll();

                if (currentNode == n - 1) {
                    return layersExplored; 
                }

                for (int neighbor : adjList.get(currentNode)) {
                    if (visited[neighbor]) continue;
                    nodeQueue.add(neighbor); 
                    nextLayerNodeCount++; 
                    visited[neighbor] = true;
                }
            }

            currentLayerNodeCount = nextLayerNodeCount;
            nextLayerNodeCount = 0; 
            layersExplored++; 
        }

        return -1; 
    }

    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<Integer> answer = new ArrayList<>();
        List<List<Integer>> adjList = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            adjList.get(i).add(i + 1);
        }

        for (int[] road : queries) {
            int u = road[0];
            int v = road[1];
            adjList.get(u).add(v); 
            answer.add(bfs(n, adjList));
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
