class Solution {
    public int maximalRectangle(char[][] nums) {
        int[][] p = new int[nums.length][nums[0].length];
        for(int i = 0 ; i < nums[0].length ; i++){
            int sum = 0 ;
            for(int j = 0 ; j < nums.length ; j++){
                sum += (nums[j][i]-'0');
                sum = (nums[j][i] == '0')?0:sum;
                p[j][i] = sum;
            }
        }
        int max = 0 ;
        for(int i = 0 ; i < nums.length ; i++){
            int pre1[] = pree(p[i]);
            int nex1[] = next(p[i]);
            //int max = 0 ;
            for(int k = 0 ; k < nums[0].length ; k++){
                int area = (nex1[k] - pre1[k] - 1) * p[i][k];
                max = (max > area)?max : area;
            }
        }
        return max;
    }
    int[] pree(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] pre = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            while (!st.empty() && arr[i] < arr[st.peek()]) {
                st.pop();
            }
            pre[i] = st.empty() ? -1 : st.peek();
            st.add(i);
        }
        return pre;
    }
    int[] next(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] nex = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!st.empty() && arr[i] <= arr[st.peek()]) {
                st.pop();
            }
            nex[i] = st.empty() ? arr.length : st.peek();
            st.add(i);
        }
        return nex;
    }
}