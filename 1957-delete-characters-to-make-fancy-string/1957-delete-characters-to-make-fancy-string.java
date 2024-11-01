class Solution {
    public String makeFancyString(String s) {
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            int resultLength = result.length();
            if (resultLength >= 2 && result.charAt(resultLength - 1) == s.charAt(i) 
                && result.charAt(resultLength - 2) == s.charAt(i)) {
                continue;
            }
            result.append(s.charAt(i));
        }
        
        return result.toString();
    }
}
