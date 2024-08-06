import java.util.Arrays;

public class Solution {

    public int minimumPushes(String word) {
        int arr[] = new int[26];
        for(char ch: word.toCharArray()) {
            arr[ch - 'a']++;
        }
        Arrays.sort(arr);
        int count = 0;
        int minKeyPress = 0;

        for(int i = 25; i >= 0; i--) {
            int mul = 0;
            if(count < 8) {
                mul = 1;
            } else if(count < 16) {
                mul = 2;
            } else if(count < 24) {
                mul = 3;
            } else {
                mul = 4;
            }
            int val = arr[i] * mul;
            minKeyPress += val;
            count++;
        }
        return minKeyPress;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.minimumPushes("example"));  // Example usage
    }
}
