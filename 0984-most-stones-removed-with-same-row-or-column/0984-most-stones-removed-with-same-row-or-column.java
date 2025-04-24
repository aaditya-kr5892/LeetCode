class disjoint{
    List<Integer> parent = new ArrayList<>();
    List<Integer> rank = new ArrayList<>();
    disjoint(int n){
        for(int i = 0 ; i < n+1 ; i++){
            rank.add(0);
            parent.add(i);
        }
    
    }
    int findParent(int n){
        if(parent.get(n) == n){
            return n;
        }
        parent.set(n,findParent(parent.get(n)));
        return parent.get(n);
    }
    void unionRank(int u,int v){
        if(findParent(u) == findParent(v)){
            return;
        }
        if(rank.get(u) < rank.get(v)){
            parent.set(parent.get(u),parent.get(v));
        }
        else if(rank.get(u) > rank.get(v)){
            parent.set(parent.get(v),parent.get(u));
        }
        else{
            parent.set(parent.get(v),parent.get(u));
            rank.set(parent.get(u),rank.get(u)+1);
        }
    }
}
class Solution {
    public int removeStones(int[][] stones) {
        int maxR = 0, maxC = 0;
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int i = 0 ; i < stones.length ; i++){
            maxR = Math.max(maxR,stones[i][0]);
            maxC = Math.max(maxC,stones[i][1]);
        }
        disjoint obj = new disjoint(maxR + maxC +1);
        for(int i = 0 ; i < stones.length ; i++){
            int row = stones[i][0];
            int col = stones[i][1] + maxR +1;
            obj.unionRank(row,col);
            map.put(row,1);
            map.put(col,1);
        }
        int count = 0;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(obj.findParent(entry.getKey()) == entry.getKey()){
                count++;
            }
        }
        return stones.length-count;
    }
}