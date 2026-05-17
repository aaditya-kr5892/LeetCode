class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int mat[][] = new int[position.length][2];
        for(int i = 0 ; i < mat.length ; i++){
            mat[i][0] = position[i];
            mat[i][1] = speed[i];
        }

        Arrays.sort(mat,(a, b)->Integer.compare(b[0],a[0]));

        // Stack<Double> st = new Stack<>();
        double time[] = new double[mat.length];

        for(int i = 0 ; i < mat.length ; i++){
            time[i] = (double)(target-mat[i][0])/(double)mat[i][1];
        }

        int i = 0;
        int ans = 0;
        while(i < mat.length-1){
            if(time[i] < time[i+1]){
                ans++;
            }
            else{
                time[i+1] = time[i];
            }
            i++;
        }
        if(i == 0) return 1;
        
        return ans+1;
    }
}