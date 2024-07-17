/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
	StringBuilder startPath = new StringBuilder();
	StringBuilder destPath = new StringBuilder();
	public String getDirections(TreeNode root, int startValue, int destValue) {

		dfs(root, startValue,true);
		dfs(root, destValue,false);
		startPath.reverse();
		destPath.reverse();
		int i=0,j=0;
		while(i < startPath.length() && j < destPath.length()){
			if(startPath.charAt(i) == destPath.charAt(j)){
				i++;j++;
			}else{
				break;
			}
		}

		StringBuilder sb = new StringBuilder();
		while(i< startPath.length()){
			sb.append("U");
			i++;
		}
		sb.append(destPath.substring(j));
		return sb.toString();

	}
	private boolean dfs(TreeNode root, int startValue, boolean start){
		if(root == null) return false;

		if(root.val == startValue)return true;
		boolean left = dfs(root.left,startValue,start);
		if(left){
			if(start) this.startPath.append("L");
			else this.destPath.append("L");
			return true;
		}
		boolean right = dfs(root.right,startValue,start);
		if(right){
			if(start) this.startPath.append("R");
			else this.destPath.append("R");
			return true;
		}
		return false;
	}
}