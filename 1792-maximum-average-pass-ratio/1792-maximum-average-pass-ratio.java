import java.util.*;

class Solution {

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        // Create a priority queue to maximize the gain (using a custom comparator)
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> Double.compare(
                calculateGain(classes, b[0]), // compare gain for class b
                calculateGain(classes, a[0])  // compare gain for class a
            )
        );

        // Initialize the priority queue with all classes
        for (int i = 0; i < classes.length; i++) {
            maxHeap.offer(new int[]{i});
        }

        // Distribute extra students
        while (extraStudents > 0) {
            // Get the class with the highest gain
            int classIndex = maxHeap.poll()[0];

            // Add one student to this class
            classes[classIndex][0]++;
            classes[classIndex][1]++;

            // Recalculate the gain for this class and put it back into the heap
            maxHeap.offer(new int[]{classIndex});

            extraStudents--;
        }

        // Calculate the total average pass ratio
        double totalPassRatio = 0;
        for (int i = 0; i < classes.length; i++) {
            totalPassRatio += (double) classes[i][0] / classes[i][1];
        }

        return totalPassRatio / classes.length;
    }

    // Calculate the gain of adding one student to the class
    private double calculateGain(int[][] classes, int classIndex) {
        double currentRatio = (double) classes[classIndex][0] / classes[classIndex][1];
        double newRatio = (double) (classes[classIndex][0] + 1) / (classes[classIndex][1] + 1);
        return newRatio - currentRatio;
    }
}
