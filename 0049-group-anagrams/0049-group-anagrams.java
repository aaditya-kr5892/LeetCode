class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        for(int i = 0 ; i < strs.length ; i++){
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            // long key = 0;
            String key = new String(arr);
            
            if(map.containsKey(key)){
                map.get(key).add(strs[i]);
            }
            else{
                map.put(key, new ArrayList<>());
                map.get(key).add(strs[i]);
            }
        }
        for(Map.Entry<String, List<String>> entry : map.entrySet()){
            res.add(entry.getValue());
        }
        return res;
    }
}