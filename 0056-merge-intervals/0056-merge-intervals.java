class custom implements Comparator<int[]>{
    @Override
    public int compare(int [] row1,int []row2){
        if(row1[0] < row2[0]){
            return -1;
        }
        else if(row1[0]>row2[0]){
            return 1;
        }
        else{
            return 0;
        }
    }
}
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,new custom());
        int arr[] = new int[2];
        arr[0] = intervals[0][0];
        arr[1] = intervals[0][1];
        int i = 0 ; 
        int n = intervals.length;
        List<int[]> res = new ArrayList<>();
        while(i < n){
            if(intervals[i][0] <= arr[1]){
                arr[1] = Math.max(intervals[i][1],arr[1]);
                arr[0] = Math.min(intervals[i][0],arr[0]);
                i++;
            }
            else{
                res.add(new int[]{arr[0],arr[1]});
                arr[0] = intervals[i][0];
                arr[1] = intervals[i][1];
                i++;
            }
        }
        res.add(arr);
        return res.toArray(new int[res.size()][]);
    }
}