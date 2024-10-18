import java.util.*;

public class Solution {

    public int secondMinimum(int n, int[][] edges, int time, int change) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{1, 0});  

        int[] shortest = new int[n + 1];
        int[] secondShortest = new int[n + 1];
        Arrays.fill(shortest, Integer.MAX_VALUE);
        Arrays.fill(secondShortest, Integer.MAX_VALUE);
        shortest[1] = 0;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int node = curr[0];
            int currTime = curr[1];

            int waitTime = currTime % (2 * change);
            if (waitTime >= change) {
                currTime += (2 * change - waitTime);
            }

            for (int neighbor : graph.get(node)) {
                int newTime = currTime + time;  

                if (newTime < shortest[neighbor]) {
                    secondShortest[neighbor] = shortest[neighbor];
                    shortest[neighbor] = newTime;
                    queue.offer(new int[]{neighbor, newTime});
                } else if (newTime > shortest[neighbor] && newTime < secondShortest[neighbor]) {
                    secondShortest[neighbor] = newTime;
                    queue.offer(new int[]{neighbor, newTime});
                }
            }
        }

        return secondShortest[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] edges = {{1, 2}, {1, 3}, {1, 4}, {3, 4}, {4, 5}};
        int result = solution.secondMinimum(5, edges, 3, 5);
        System.out.println(result);  
    }
}
