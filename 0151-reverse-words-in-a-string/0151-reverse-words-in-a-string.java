class Solution {
    public String reverseWords(String s) {
        // Split the string by spaces and filter out empty strings
        String[] words = s.trim().split("\\s+"); // "\\s+" handles multiple spaces
        StringBuilder sb = new StringBuilder();
        
        // Traverse words in reverse order
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if (i != 0) { // Add space between words, but not after the last word
                sb.append(' ');
            }
        }
        
        return sb.toString();
    }
}
