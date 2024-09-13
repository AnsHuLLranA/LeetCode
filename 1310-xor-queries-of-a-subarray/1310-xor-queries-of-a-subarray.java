public class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
      
        int n = arr.length;
        int[] prefixXOR = new int[n + 1]; 
        
        
        for (int i = 1; i <= n; i++) {
            prefixXOR[i] = prefixXOR[i - 1] ^ arr[i - 1];
        }

    
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            result[i] = prefixXOR[right + 1] ^ prefixXOR[left];
        }

        return result;
    }
}
