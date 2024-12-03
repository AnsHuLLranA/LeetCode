class Solution {

    public String addSpaces(String s, int[] spaces) {
        StringBuilder result = new StringBuilder();
        int spaceIndex = 0;

        for (int stringIndex = 0; stringIndex < s.length(); stringIndex++) {
            if (
                spaceIndex < spaces.length && stringIndex == spaces[spaceIndex]
            ) {
                result.append(' ');
                spaceIndex++;
            }
            result.append(s.charAt(stringIndex));
        }
        return result.toString();
    }
}