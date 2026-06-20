import java.util.HashMap;
import java.util.Map;

class Solution {
    public String largestWordCount(String[] messages, String[] senders) {
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < senders.length; i++) {
            int wc = wordCount(messages[i]);
            map.put(senders[i], map.getOrDefault(senders[i], 0) + wc);
        }
        
        int max = Integer.MIN_VALUE;
        String res = "";
        
        for (String sender : map.keySet()) {
            int currentCount = map.get(sender);
            
            if (currentCount > max || (currentCount == max && sender.compareTo(res) > 0)) {
                max = currentCount;
                res = sender;
            }
        }
        
        return res;
    }
    
    int wordCount(String s) {
        int count = 1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                count++;
            }
        }
        return count;
    }
}