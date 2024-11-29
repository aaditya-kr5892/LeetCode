class Solution {
    public int lengthOfLastWord(String s) {
        return (s.trim().substring(s.trim().lastIndexOf(" ")+1).length());
    }
}