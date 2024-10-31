class Solution {
    public String reverseWords(String s) {
        // Step 1: Trim the input string to remove leading and trailing spaces
        s = s.trim();
        
        // Step 2: Split the string by one or more spaces to get all words
        String[] words = s.split("\\s+");
        
        // Step 3: Reverse the list of words
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if (i != 0) {
                sb.append(' ');
            }
        }
        
        // Step 4: Join the words with a single space and return the result
        return sb.toString();
    }
}