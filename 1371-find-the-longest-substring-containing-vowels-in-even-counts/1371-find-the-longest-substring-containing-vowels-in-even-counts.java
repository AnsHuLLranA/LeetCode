class Solution {
    public int findTheLongestSubstring(String s) {
        Map<Integer, Integer> mp = new HashMap<>();
        int mask = 0;
        mp.put(mask, -1);
        int maxL = 0;
        for (int i = 0; i < s.length(); i++) {
            int val = 0;
            if (s.charAt(i) == 'a')      val = (1 << 0);
            else if (s.charAt(i) == 'e') val = (1 << 1);
            else if (s.charAt(i) == 'i') val = (1 << 2);
            else if (s.charAt(i) == 'o') val = (1 << 3);
            else if (s.charAt(i) == 'u') val = (1 << 4);

            mask ^= val; //xor nikala
            
            if (!mp.containsKey(mask)) //agar past me nahi dekha to map me daaldo
                mp.put(mask, i);
            
            maxL = Math.max(maxL, i - mp.get(mask)); //maxL nikaal lo
        }
        return maxL;
    }
}