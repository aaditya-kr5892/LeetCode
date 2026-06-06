class Solution {
    int count = 0;
    public int reversePairs(int[] nums) {
        f(nums, 0, nums.length-1);
        return count;
    }
    void f(int[] nums, int i, int j){
        if(i >= j){
            return ;
        }
        int mid = (i+j)/2;

        f(nums, i, mid);
        f(nums, mid+1, j);

        int l = i;
        int r = mid+1;

        while (l <= mid && r <= j){
            if (r <= j && (long) nums[l] > 2.0 * nums[r]){
                count = count + (mid-l+1);
                r++;
            }
            else{
                l++;
            }
        }

        merge(nums, i, mid, j);
    }

    void merge(int[] nums, int i, int mid, int j){
        int m[] = new int[j-i+1];
        int k = 0;
        int l = i;
        int r = mid+1;
        while(l <= mid && r <= j){
            if(nums[l] <= nums[r]){
                m[k++] = nums[l++];
            }
            else{
                m[k++] = nums[r++];
            }
        }
        while(l <= mid){
            m[k++] = nums[l++];
        }
        while(r <= j){
            m[k++] = nums[r++];
        }

        for (int x = 0; x < m.length; x++) {
            nums[i + x] = m[x];
        }
        return;
    }
}