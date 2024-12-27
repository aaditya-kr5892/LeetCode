class Solution {
    public int sumSubarrayMins(int[] arr) {
        Solution obj = new Solution();
        int result = 0 ; 
        int pre[] = new int[arr.length];
        int nex[] = new int[arr.length];
        pre = obj.pree(arr);
        nex = obj.next(arr);
        int m = (int)Math.pow(10,9) + 7;
        for(int i = 0 ; i < arr.length ; i++){
            result = (int)(result + ((long)(i - pre[i]) * (nex[i] - i) % m * arr[i] % m) % m) % m;
        }
        return result;
    }
    int[] pree(int arr[]){
        Stack<Integer> st = new Stack<>();
        int pre[] = new int[arr.length];
        for(int i = 0 ; i < arr.length ; i++){
            while(!st.empty() && arr[i] < arr[st.peek()]){
                st.pop();
            }
            if(st.empty()){
                pre[i] = -1;
            }
            else{
                pre[i] =st.peek();
            }
            st.add(i);
        }
        return pre;
    }

    int[] next(int arr[]){
        Stack<Integer> st = new Stack<>();
        int nex[] = new int[arr.length];
        for(int i = arr.length-1 ; i >= 0 ; i--){
            while(!st.empty() && arr[i] <= arr[st.peek()]){
                st.pop();
            }
            if(st.empty()){
                nex[i] = arr.length;
            }
            else{
                nex[i] =st.peek();
            }
            st.add(i);
        }
        return nex;
    }
}