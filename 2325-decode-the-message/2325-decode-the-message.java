class Solution {
    public String decodeMessage(String key, String message) {
        Set<Character> set = new HashSet<>();
        char c = 'a';
        StringBuilder sb = new StringBuilder();

        Map<Character, Character> map = new HashMap<>();
        for(int i = 0 ; i < key.length() ; i++){
            if(key.charAt(i) == ' ') continue;
            if(!set.contains(key.charAt(i)))
                map.put(key.charAt(i), c++);
            set.add(key.charAt(i));
        }
        for(int i = 0 ; i < message.length() ; i++){
            if(message.charAt(i) == ' '){
                sb.append(' ');
                continue;
            }
            sb.append(map.get(message.charAt(i)));

        }
        return sb.toString();
    }
}