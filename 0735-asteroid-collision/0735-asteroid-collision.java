class Solution {
    public int[] asteroidCollision(int[] nums) {
        Stack<Integer> st = new Stack<>();
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] > 0){
                st.add(nums[i]);
            }
            else if(st.empty() || st.peek() < 0){
                st.add(nums[i]);
            }
            else{
                if(Math.abs(st.peek()) > Math.abs(nums[i])){
                    continue;
                }
                else if(Math.abs(st.peek()) == Math.abs(nums[i])){
                    st.pop();
                    continue;
                }
                else{
                    while(!st.empty() && st.peek() > 0 && st.peek() < Math.abs(nums[i])){
                        st.pop();
                    }
                    if (st.empty() || st.peek() < 0) {
                        st.add(nums[i]);
                    }
                    else if (Math.abs(st.peek()) == Math.abs(nums[i])) {
                        st.pop();
                    }
                }
            }
        }
        int arr[] = new int[st.size()];
        if(!st.empty()){
            for(int i = arr.length-1 ; i>= 0 ; i--){
                arr[i] = st.pop();
            }
            return arr;
        }
        return arr;
    }
}