import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] result = new int[rows * cols][2];
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};  // Right, Down, Left, Up
        int steps = 1;  // Number of steps in the current direction
        int i = rStart, j = cStart;
        int index = 0;

        result[index++] = new int[]{i, j};

        while (index < rows * cols) {
            for (int[] d : directions) {
                for (int k = 0; k < steps; k++) {
                    i += d[0];
                    j += d[1];

                    if (i >= 0 && i < rows && j >= 0 && j < cols) {
                        result[index++] = new int[]{i, j};
                    }

                    if (index == rows * cols) {
                        return result;
                    }
                }

                if (d == directions[1] || d == directions[3]) {
                    steps++;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] result = sol.spiralMatrixIII(5, 6, 1, 4);

        for (int[] coord : result) {
            System.out.println("[" + coord[0] + ", " + coord[1] + "]");
        }
    }
}
