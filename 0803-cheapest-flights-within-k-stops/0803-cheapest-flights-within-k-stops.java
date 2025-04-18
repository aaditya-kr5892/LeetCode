class custom{
    int stops;
    int node;
    int distance;
    custom(int stops, int node, int distance){
        this.stops = stops;
        this.node = node;
        this.distance = distance;
    }
}
class pair{
    int node;
    int weight;
    pair(int node, int weight){
        this.node = node;
        this.weight = weight;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Queue<custom> que = new LinkedList<>();
        int dist[] = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        ArrayList<ArrayList<pair>> adj = new ArrayList<>();
        for(int i = 0 ;  i < n ; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0 ; i < flights.length ; i++){
            adj.get(flights[i][0]).add(new pair(flights[i][1],flights[i][2]));
        }
        que.add(new custom(0,src,0));
        while(!que.isEmpty()){
            custom t = que.poll();
            for(int i = 0 ; i < adj.get(t.node).size() ; i++){
                if(dist[adj.get(t.node).get(i).node] > t.distance + adj.get(t.node).get(i).weight && t.stops < k+1){
                    que.add(new custom(t.stops+1,adj.get(t.node).get(i).node,t.distance + adj.get(t.node).get(i).weight));
                    dist[adj.get(t.node).get(i).node] = t.distance + adj.get(t.node).get(i).weight;
                }
            }
        }
        return dist[dst] == Integer.MAX_VALUE?-1:dist[dst];
    }
}