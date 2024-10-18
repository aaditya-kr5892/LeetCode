class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        s = s.trim(); // Remove leading and trailing spaces
        int n = s.length();
        int j = n - 1;

        while (j >= 0) {
            // Skip spaces
            while (j >= 0 && s.charAt(j) == ' ') {
                j--;
            }

            int i = j; // End of the current word
            // Find the start of the current word
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }

            // Append the current word to the StringBuilder
            sb.append(s, i + 1, j + 1); // Append the word (i+1 to j+1)

            // Append a space if there are more words to process
            if (i > 0) {
                sb.append(' ');
            }

            j = i - 1; // Move j to the next word
        }

        return sb.toString(); // Convert to string and return
    }
}
