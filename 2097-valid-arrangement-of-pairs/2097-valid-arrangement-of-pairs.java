class Solution {

    public int[][] validArrangement(int[][] pairs) {
        Map<Integer, Deque<Integer>> adjacencyMatrix = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, Integer> outDegree = new HashMap<>();
        for (int[] pair : pairs) {
            int start = pair[0], end = pair[1];
            adjacencyMatrix
                .computeIfAbsent(start, k -> new ArrayDeque<>())
                .add(end);
            outDegree.put(start, outDegree.getOrDefault(start, 0) + 1);
            inDegree.put(end, inDegree.getOrDefault(end, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();
        int startNode = -1;
        for (int node : outDegree.keySet()) {
            if (outDegree.get(node) == inDegree.getOrDefault(node, 0) + 1) {
                startNode = node;
                break;
            }
        }
        if (startNode == -1) {
            startNode = pairs[0][0];
        }

        visit(startNode, adjacencyMatrix, result);

        Collections.reverse(result);

        int[][] pairedResult = new int[result.size() - 1][2];
        for (int i = 1; i < result.size(); i++) {
            pairedResult[i - 1] = new int[] {
                result.get(i - 1),
                result.get(i),
            };
        }

        return pairedResult;
    }

    private void visit(
        int node,
        Map<Integer, Deque<Integer>> adjMatrix,
        List<Integer> res
    ) {
        Deque<Integer> neighbors = adjMatrix.get(node);
        while (neighbors != null && !neighbors.isEmpty()) {
            int nextNode = neighbors.pollFirst();
            visit(nextNode, adjMatrix, res);
        }
        res.add(node);
    }
}