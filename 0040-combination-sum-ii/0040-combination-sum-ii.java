import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {  
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(candidates);

        dfs(candidates, result, target, new ArrayList<>(), 0);
        return result;
    }
    
    private void dfs(int[] candidates, List<List<Integer>> result, int target, List<Integer> currentCombination, int start) {
       
        if (target == 0) {
            result.add(new ArrayList<>(currentCombination));
            return;
        }


        for (int i = start; i < candidates.length; i++) {
          
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            if (candidates[i] > target) {
                break;
            }

            currentCombination.add(candidates[i]);

            dfs(candidates, result, target - candidates[i], currentCombination, i + 1);
         
            currentCombination.remove(currentCombination.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        List<List<Integer>> result = solution.combinationSum2(candidates, target);
        System.out.println(result);
    }
}
