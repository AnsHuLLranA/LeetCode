//Optimal runtime using array
class Solution {
    using pii = pair<int, int>;

    // Helper function to calculate height and update level data
    int findHeight(TreeNode* curr, int level, vector<int>& node_level, vector<int>& node_height, vector<pii>& top2_height) {
        if (!curr) return 0;

        // Recursively find heights of left and right subtrees
        int height = 1 + max(findHeight(curr->left, level + 1, node_level, node_height, top2_height),
                             findHeight(curr->right, level + 1, node_level, node_height, top2_height));

        // Store the node's level and height
        node_level[curr->val] = level;
        node_height[curr->val] = height;

        // Maintain only the top 2 heights at each level
        if (height > top2_height[level].first) {
            top2_height[level].second = top2_height[level].first;
            top2_height[level].first = height;
        } else if (height > top2_height[level].second) {
            top2_height[level].second = height;
        }

        return height;
    }

public:
    vector<int> treeQueries(TreeNode* root, vector<int>& queries) {
        int n = 100001; // Assumes node values range from 1 to 100000
        vector<int> node_level(n, -1);  // Stores level of each node
        vector<int> node_height(n, 0);  // Stores height of each node
        vector<pii> top2_height(n, {0, 0});  // Top-2 heights at each level {maxHeight, secondMaxHeight}

        // Compute the height for each node starting from the root
        findHeight(root, 0, node_level, node_height, top2_height);

        vector<int> res;
        for (int query_node : queries) {
            int level = node_level[query_node];
            int height = node_height[query_node];

            // Determine the result based on whether the query_node is the tallest at that level
            int max_height = (top2_height[level].first == height) 
                             ? top2_height[level].second 
                             : top2_height[level].first;

            res.push_back(max_height + level - 1);
        }

        return res;
    }
};

/*
//Generalized Map solution
class Solution {
    using pii = pair<int, int>;

    // Helper function to calculate height and update level data
    int findHeight(TreeNode* curr, int level, unordered_map<int, pii>& node_level, unordered_map<int, pii>& top2_nodes_at_level) {
        if (!curr) return 0;

        // Recursively find heights of left and right subtrees
        int height = 1 + max(findHeight(curr->left, level + 1, node_level, top2_nodes_at_level),
                             findHeight(curr->right, level + 1, node_level, top2_nodes_at_level));

        // Store the node's level and height
        node_level[curr->val] = {level, height};

        // Maintain only the top 2 heights at each level
        if (height > top2_nodes_at_level[level].first) {
            top2_nodes_at_level[level].second = top2_nodes_at_level[level].first;
            top2_nodes_at_level[level].first = height;
        } else if (height > top2_nodes_at_level[level].second) {
            top2_nodes_at_level[level].second = height;
        }

        return height;
    }

public:
    vector<int> treeQueries(TreeNode* root, vector<int>& queries) {
        unordered_map<int, pii> top2_nodes_at_level;  // Top-2 nodes at a given level {maxHeight, secondMaxHeight}
        unordered_map<int, pii> node_level;  // Level and height of each node {level, height}

        // Compute the height for each node starting from the root
        findHeight(root, 0, node_level, top2_nodes_at_level);

        vector<int> res;
        for (int query_node : queries) {
            int level = node_level[query_node].first;
            int height = node_level[query_node].second;

            // Determine the result based on whether the query_node is the tallest at that level
            int max_height = (top2_nodes_at_level[level].first == height) 
                             ? top2_nodes_at_level[level].second 
                             : top2_nodes_at_level[level].first;

            res.push_back(max_height + level - 1);
        }

        return res;
    }
};

import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) { val = x; }
}

// JAVA: Optimal runtime using array
class SolutionOptimal {
    static class Pair {
        int first, second;
        Pair(int f, int s) { first = f; second = s; }
    }

    int findHeight(TreeNode curr, int level, int[] node_level, int[] node_height, Pair[] top2_height) {
        if (curr == null) return 0;

        int height = 1 + Math.max(findHeight(curr.left, level + 1, node_level, node_height, top2_height),
                                  findHeight(curr.right, level + 1, node_level, node_height, top2_height));

        node_level[curr.val] = level;
        node_height[curr.val] = height;

        if (height > top2_height[level].first) {
            top2_height[level].second = top2_height[level].first;
            top2_height[level].first = height;
        } else if (height > top2_height[level].second) {
            top2_height[level].second = height;
        }

        return height;
    }

    public List<Integer> treeQueries(TreeNode root, List<Integer> queries) {
        int n = 100001;
        int[] node_level = new int[n];
        int[] node_height = new int[n];
        Arrays.fill(node_level, -1);
        Pair[] top2_height = new Pair[n];
        for (int i = 0; i < n; i++) top2_height[i] = new Pair(0, 0);

        findHeight(root, 0, node_level, node_height, top2_height);

        List<Integer> res = new ArrayList<>();
        for (int query_node : queries) {
            int level = node_level[query_node];
            int height = node_height[query_node];
            int max_height = (top2_height[level].first == height) ? top2_height[level].second : top2_height[level].first;
            res.add(max_height + level - 1);
        }
        return res;
    }
}

// JAVA: Generalized map solution
class SolutionMap {
    static class Pair {
        int first, second;
        Pair(int f, int s) { first = f; second = s; }
    }

    int findHeight(TreeNode curr, int level, Map<Integer, Pair> node_level, Map<Integer, Pair> top2_nodes_at_level) {
        if (curr == null) return 0;

        int height = 1 + Math.max(findHeight(curr.left, level + 1, node_level, top2_nodes_at_level),
                                  findHeight(curr.right, level + 1, node_level, top2_nodes_at_level));

        node_level.put(curr.val, new Pair(level, height));

        if (height > top2_nodes_at_level.getOrDefault(level, new Pair(0, 0)).first) {
            top2_nodes_at_level.put(level, new Pair(height, top2_nodes_at_level.getOrDefault(level, new Pair(0, 0)).first));
        } else if (height > top2_nodes_at_level.get(level).second) {
            top2_nodes_at_level.get(level).second = height;
        }

        return height;
    }

    public List<Integer> treeQueries(TreeNode root, List<Integer> queries) {
        Map<Integer, Pair> top2_nodes_at_level = new HashMap<>();
        Map<Integer, Pair> node_level = new HashMap<>();

        findHeight(root, 0, node_level, top2_nodes_at_level);

        List<Integer> res = new ArrayList<>();
        for (int query_node : queries) {
            int level = node_level.get(query_node).first;
            int height = node_level.get(query_node).second;
            int max_height = (top2_nodes_at_level.get(level).first == height) ? top2_nodes_at_level.get(level).second : top2_nodes_at_level.get(level).first;
            res.add(max_height + level - 1);
        }
        return res;
    }
}

from typing import List, Optional, Tuple
from collections import defaultdict

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

# Optimal runtime using array
class SolutionOptimal:
    def findHeight(self, curr: Optional[TreeNode], level: int, node_level: List[int], node_height: List[int], top2_height: List[Tuple[int, int]]) -> int:
        if not curr:
            return 0

        height = 1 + max(self.findHeight(curr.left, level + 1, node_level, node_height, top2_height),
                         self.findHeight(curr.right, level + 1, node_level, node_height, top2_height))

        node_level[curr.val] = level
        node_height[curr.val] = height

        if height > top2_height[level][0]:
            top2_height[level] = (height, top2_height[level][0])
        elif height > top2_height[level][1]:
            top2_height[level] = (top2_height[level][0], height)

        return height

    def treeQueries(self, root: TreeNode, queries: List[int]) -> List[int]:
        n = 100001
        node_level = [-1] * n
        node_height = [0] * n
        top2_height = [(0, 0)] * n

        self.findHeight(root, 0, node_level, node_height, top2_height)

        res = []
        for query_node in queries:
            level = node_level[query_node]
            height = node_height[query_node]
            max_height = top2_height[level][1] if top2_height[level][0] == height else top2_height[level][0]
            res.append(max_height + level - 1)
        return res

# Generalized map solution
class SolutionMap:
    def findHeight(self, curr: Optional[TreeNode], level: int, node_level: dict, top2_nodes_at_level: dict) -> int:
        if not curr:
            return 0

        height = 1 + max(self.findHeight(curr.left, level + 1, node_level, top2_nodes_at_level),
                         self.findHeight(curr.right, level + 1, node_level, top2_nodes_at_level))

        node_level[curr.val] = (level, height)

        if height > top2_nodes_at_level[level][0]:
            top2_nodes_at_level[level] = (height, top2_nodes_at_level[level][0])
        elif height > top2_nodes_at_level[level][1]:
            top2_nodes_at_level[level] = (top2_nodes_at_level[level][0], height)

        return height

    def treeQueries(self, root: TreeNode, queries: List[int]) -> List[int]:
        top2_nodes_at_level = defaultdict(lambda: (0, 0))
        node_level = {}

        self.findHeight(root, 0, node_level, top2_nodes_at_level)

        res = []
        for query_node in queries:
            level, height = node_level[query_node]
            max_height = top2_nodes_at_level[level][1] if top2_nodes_at_level[level][0] == height else top2_nodes_at_level[level][0]
            res.append(max_height + level - 1)
        return res
*/