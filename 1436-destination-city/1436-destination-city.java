import java.util.*;

class Solution {
    public String destCity(List<List<String>> paths) {
        Map<String, Integer> cityDegreeMap = new HashMap<>();
        for (var path : paths) {
            // Increment the degree for the starting city
            cityDegreeMap.put(path.get(0), cityDegreeMap.getOrDefault(path.get(0), 0) + 1);
            // Decrement the degree for the destination city
            cityDegreeMap.put(path.get(1), cityDegreeMap.getOrDefault(path.get(1), 0) - 1);
        }
        // Traverse the degree map to find the city with a degree of -1
        for (var cityDegPair : cityDegreeMap.entrySet()) {
            if (cityDegPair.getValue() == -1) return cityDegPair.getKey();
        }
        return "";
    }
}
