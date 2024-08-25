import java.util.ArrayList;
import java.util.List;

class Solution {
   
    List<Integer> ans;


    public void traverse(TreeNode root) {
        if (root == null) return;
        traverse(root.left);
        traverse(root.right);
        ans.add(root.val);
    }


    public List<Integer> postorderTraversal(TreeNode root) { 
        ans = new ArrayList<>(); 
        traverse(root);
        return ans;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
