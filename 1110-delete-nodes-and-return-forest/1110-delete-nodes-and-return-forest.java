import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> ans = new ArrayList<>();
        ans.add(root);
        for (int i : to_delete) {
            List<TreeNode> nextRound = new ArrayList<>();
            boolean nodeToBeDeletedAlreadyFound = false;
            for (TreeNode node : ans) {
                List<TreeNode> forest = new ArrayList<>();
                if (nodeToBeDeletedAlreadyFound) {
                    nextRound.add(node);
                } else {
                    if (search(node, null, forest, i)) {
                        if (node.val == i) {
                            nextRound.addAll(forest);
                        } else {
                            nextRound.addAll(forest);
                            nextRound.add(node);
                        }
                        nodeToBeDeletedAlreadyFound = true;
                    } else {
                        nextRound.add(node);
                    }
                }
            }
            ans = nextRound;
        }
        return ans;
    }

    public boolean search(TreeNode curNode, TreeNode parent, List<TreeNode> forest, int t) {
        if (curNode == null) {
            return false;
        }
        if (curNode.val == t) {
            if (curNode.left != null) {
                forest.add(curNode.left);
            }
            if (curNode.right != null) {
                forest.add(curNode.right);
            }
            if (parent != null) {
                if (parent.left != null && parent.left.val == t) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            }
            return true;
        }
        return search(curNode.left, curNode, forest, t) || search(curNode.right, curNode, forest, t);
    }
}

