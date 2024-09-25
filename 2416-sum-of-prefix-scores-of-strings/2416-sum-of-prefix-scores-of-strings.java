import java.util.*;

class Solution {
    class TrieNode {
        Map<Character, TrieNode> children;
        int count;

        TrieNode() {
            children = new HashMap<>();
            count = 0;
        }
    }

   
    class Trie {
        TrieNode root;

        Trie() {
            root = new TrieNode();
        }

        void insert(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                node.children.putIfAbsent(c, new TrieNode());
                node = node.children.get(c);
                node.count++; 
            }
        }
        int getScore(String word) {
            TrieNode node = root;
            int score = 0;
            for (char c : word.toCharArray()) {
                if (node.children.containsKey(c)) {
                    node = node.children.get(c);
                    score += node.count;  
                } else {
                    break;
                }
            }
            return score;
        }
    }

    public int[] sumPrefixScores(String[] words) {
        Trie trie = new Trie();


        for (String word : words) {
            trie.insert(word);
        }

     
        int[] result = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            result[i] = trie.getScore(words[i]);
        }

        return result;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] words = {"a", "ab", "abc", "cab"};
        int[] result = solution.sumPrefixScores(words);
        System.out.println(Arrays.toString(result));  
    }
}
