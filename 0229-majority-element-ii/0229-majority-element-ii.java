class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int count1 = 0, count2 = 0;
        int cand1 = Integer.MIN_VALUE , cand2 = Integer.MIN_VALUE;

        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] == cand1){
                count1++;
            }
            else if(nums[i] == cand2){
                count2++;
            }
            else if(count1 == 0){
                cand1 = nums[i];
                count1 = 1;
            }
            else if(count2 == 0){
                cand2 = nums[i];
                count2 = 1;
            }
            else{
                count1--;
                count2--;
            }
        }
        // System.out.println(cand1+" "+cand2);
        count1 = 0;
        count2 = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] == cand1){
                count1++;
            }
            else if(nums[i] == cand2){
                count2++;
            }
        }

        List<Integer> list = new ArrayList<>();
        if(count1 > nums.length/3){
            list.add(cand1);
        }
        if(count2 > nums.length/3){
            list.add(cand2);
        }
        return list;
    }
}