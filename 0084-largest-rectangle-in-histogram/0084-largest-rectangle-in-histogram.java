class Solution {
    public int largestRectangleArea(int[] arr) {
        int pre1[] = pree(arr);
        int nex1[] = next(arr);
        int max = 0 ;
        for(int i = 0 ; i < arr.length ; i++){
            int area = (nex1[i] - pre1[i] - 1)*arr[i];
            max = (max > area)?max : area;
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