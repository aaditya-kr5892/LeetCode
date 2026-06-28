class Solution {
    public List<List<Integer>> filterOccupiedIntervals(int[][] inter, int fs, int fe) {
        Arrays.sort(inter, (a,b)->Integer.compare(a[0],b[0]));
        List<List<Integer>> list = new ArrayList<>();
        // int visited[] = new int[matrix.length];
        List<Integer> l = new ArrayList<>();
        l.add(inter[0][0]);
        l.add(inter[0][1]);
        list.add(l);
        int j = 0;
        for(int i = 1 ; i < inter.length ; i++){
            l = new ArrayList<>();
            int t = -1, t1=-1;
            if(inter[i][0] >= list.get(j).get(0) && inter[i][0] <= list.get(j).get(1)+1){
                t = list.get(j).get(0);
                t1 = list.get(j).get(1);
                list.remove(list.size()-1);
                l.add(t);
                l.add(Math.max(t1,inter[i][1]));
                list.add(l);
                // i--;
                // visited[i-1] = 1;
            }

            else{
                l.add(inter[i][0]);
                l.add(inter[i][1]);
                list.add(l);
                j++;
            }
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) { 
            int s = list.get(i).get(0);
            int e = list.get(i).get(1);

            if (e < fs || s > fe) {
                res.add(list.get(i));
            }
            else if (s >= fs && e <= fe) {
                continue; 
            }
            else if (s < fs && e > fe) {
                res.add(new ArrayList<>(Arrays.asList(s, fs - 1)));
                res.add(new ArrayList<>(Arrays.asList(fe + 1, e)));
            }
            else if (s < fs && e <= fe) {
                res.add(new ArrayList<>(Arrays.asList(s, fs - 1)));
            }
            else if (s >= fs && e > fe) {
                res.add(new ArrayList<>(Arrays.asList(fe + 1, e)));
            }
        }
        
        return res;
    }
}