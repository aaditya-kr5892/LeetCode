class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<Integer> list = new ArrayList<>();
        List<String> res = new ArrayList<>();
        int last = -1;
        for(int i = 0 ; i < groups.length ; i++){
            if(groups[i] != last){
                list.add(i);
                last = groups[i];
            }
        }
        for(int i = 0 ; i < list.size() ; i++){
            res.add(words[list.get(i)]);
        }
        return res
        ;
    }
}