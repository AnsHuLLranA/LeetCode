class Solution {

    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int numCols = matrix[0].length;
        int maxIdenticalRows = 0;

        for (int[] currentRow : matrix) {
            int[] flippedRow = new int[numCols];
            int identicalRowCount = 0;

            for (int col = 0; col < numCols; col++) {
                flippedRow[col] = 1 - currentRow[col];
            }

            for (int[] compareRow : matrix) {
                if (
                    Arrays.equals(compareRow, currentRow) ||
                    Arrays.equals(compareRow, flippedRow)
                ) {
                    identicalRowCount++;
                }
            }

            maxIdenticalRows = Math.max(maxIdenticalRows, identicalRowCount);
        }

        return maxIdenticalRows;
    }
}