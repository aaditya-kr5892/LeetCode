class Solution {
    public int[] searchRange(int[] nums, int target) {
        int ans[] = new int[2];
        ans[0] = first(nums,target);
        ans[1] = last(nums,target);
        return ans;
    }
    static int first(int arr[],int target){
        int low = 0 ; 
        int high = arr.length-1 ;
        int k = 0 ;
        int first = -1;
        while(low<=high){
            int mid = (low+high)/2;
            if(arr[mid] == target){
                first = mid;
                high= mid-1;
            }
            else if(arr[mid] < target)
            low = mid+1;
            else 
            high = mid -1;
        }
        return first;
    }
    static int last(int arr[],int target){
        int low = 0 ; 
        int high = arr.length-1 ;
        int k = 0 ;
        int last = -1;
        while(low<=high){
            int mid = (low+high)/2;
            if(arr[mid] == target){
                last = mid;
                low = mid + 1;
            }
            else if(arr[mid] < target)
            low = mid + 1;
            else 
            high = mid - 1;
        }
        return last;
    }
    
}