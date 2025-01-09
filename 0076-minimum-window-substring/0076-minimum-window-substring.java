class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()){
            return "";
        }
        //Map<Character,Integer> mapS = new HashMap<>();
        Map<Character,Integer> map = new HashMap<>();
        int start = -1;
        int end = -1;
        for(int i = 0 ; i < t.length() ; i++){
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)+1);
        }
        int l = 0 , r = 0 , count = 0 , min = Integer.MAX_VALUE;
        while(r < s.length()){
            map.put(s.charAt(r),map.getOrDefault(s.charAt(r),0)-1);
            if(map.get(s.charAt(r)) >= 0){
                count++;
            }
            while(count >= t.length()){
                if(min > r-l+1){
                    min = r-l+1;
                    start = l;
                    end = r;
                }
                if(map.get(s.charAt(l)) == 0)
                count--;
                map.put(s.charAt(l),map.get(s.charAt(l))+1);
                l++;
            }
            r++;
        }
        if(start == -1 && end == -1)
        return "";
        return s.substring(start,end+1);
    }
}