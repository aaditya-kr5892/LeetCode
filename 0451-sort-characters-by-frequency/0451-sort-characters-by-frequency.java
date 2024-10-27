class Solution {
    public String frequencySort(String s) {
        HashMap <Character , Integer> map = new HashMap<>();
        for(int i = 0 ; i < s.length() ; i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        ArrayList <Character> list = new ArrayList<Character>(map.keySet());
        list.sort((ob1,ob2) -> map.get(ob2)-map.get(ob1));
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < list.size() ; i++){
            for(int j = 0 ; j < map.get(list.get(i)); j++){
                sb.append(list.get(i));
            }
        }
        return sb.toString();
    }
}