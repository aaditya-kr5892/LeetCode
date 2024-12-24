class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int arr[] = new int[nums1.length];
        Stack<Integer> st = new Stack<>(); 
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = nums2.length-1 ; i >=0 ; i--){
            while(!st.empty() && nums2[i]>=st.peek()  )
            st.pop();
            if(st.empty()){
                st.add(nums2[i]);
                map.put(nums2[i],-1);
            }
            else{
                map.put(nums2[i],st.peek());
            }
            st.add(nums2[i]);
        }
        for(int i = 0 ; i < nums1.length ; i++){
            arr[i] = map.get(nums1[i]);
        }
        return arr;
    }
}