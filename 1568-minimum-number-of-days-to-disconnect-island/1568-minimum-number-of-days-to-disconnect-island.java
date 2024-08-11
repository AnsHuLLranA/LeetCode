class Solution {
    private int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int minDays(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        if (countIslands(grid) != 1) return 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    if (countIslands(grid) != 1) {
                        return 1;
                    }
                    grid[i][j] = 1;
                }
            }
        }

        return 2;
    }

    private int countIslands(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int islands = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    islands++;
                    dfs(grid, visited, i, j);
                }
            }
        }

        return islands;
    }
    private void dfs(int[][] grid, boolean[][] visited, int x, int y) {
        int m = grid.length, n = grid[0].length;
        visited[x][y] = true;

        for (int[] direction : directions) {
            int newX = x + direction[0];
            int newY = y + direction[1];

            if (newX >= 0 && newX < m && newY >= 0 && newY < n && grid[newX][newY] == 1 && !visited[newX][newY]) {
                dfs(grid, visited, newX, newY);
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] grid = {{1, 1, 0, 0, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 1, 1}};
        System.out.println(sol.minDays(grid));  // Output should be 2
    }
}
