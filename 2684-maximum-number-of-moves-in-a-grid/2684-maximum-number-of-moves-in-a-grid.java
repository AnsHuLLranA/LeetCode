import java.util.Arrays;

public class Solution {
    private int[][] grid;
    private int m, n;
    private int[][] memo;

    public int maxMoves(int[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        this.memo = new int[m][n];
        
        // Initialize memoization array with -1
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        
        int maxMoves = 0;
        // Start from each cell in the first column
        for (int i = 0; i < m; i++) {
            maxMoves = Math.max(maxMoves, dfs(i, 0));
        }
        
        return maxMoves;
    }

    private int dfs(int row, int col) {
        // If we have reached the last column, no more moves can be made
        if (col == n - 1) {
            return 0;
        }
        
        // If the result is already computed, return it
        if (memo[row][col] != -1) {
            return memo[row][col];
        }

        int maxMovesFromCurrent = 0;
        
        // Possible directions to move
        int[] dRow = {-1, 0, 1}; // Up, same row, down
        for (int dr : dRow) {
            int newRow = row + dr;
            int newCol = col + 1;

            // Check bounds and if the move is valid
            if (newRow >= 0 && newRow < m && grid[newRow][newCol] > grid[row][col]) {
                maxMovesFromCurrent = Math.max(maxMovesFromCurrent, 1 + dfs(newRow, newCol));
            }
        }
        
        // Store the computed result in the memo array
        memo[row][col] = maxMovesFromCurrent;
        return maxMovesFromCurrent;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example 1
        int[][] grid1 = {
            {2, 4, 3, 5},
            {5, 4, 9, 3},
            {3, 4, 2, 11},
            {10, 9, 13, 15}
        };
        System.out.println("Maximum moves: " + solution.maxMoves(grid1)); // Output: 3

        // Example 2
        int[][] grid2 = {
            {3, 2, 4},
            {2, 1, 9},
            {1, 1, 7}
        };
        System.out.println("Maximum moves: " + solution.maxMoves(grid2)); // Output: 0
    }
}
