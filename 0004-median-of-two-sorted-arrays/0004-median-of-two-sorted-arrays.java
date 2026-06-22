class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int ind1 = -1;
        int ind2 = -1;
        int i = 0, j = 0;
        int i1 = (nums1.length + nums2.length)/2;
        int i2 = (nums1.length + nums2.length)/2-1;
        int count = 0;
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] < nums2[j]){
                if(count == i1){
                    ind1 = nums1[i];
                }
                if(count == i2){
                    ind2 = nums1[i];
                }
                i++;
            }
            else{
                if(count == i1){
                    ind1 = nums2[j];
                }
                if(count == i2){
                    ind2 = nums2[j];
                }
                j++;
            }
            count++;
            if(ind1 != -1 && ind2 != -1){
                break;
            }
        }
        while(i < nums1.length){
            if(count == i1){
                ind1 = nums1[i];
            }
            if(count == i2){
                ind2 = nums1[i];
            }
            i++;
            count++;
        }
        while(j < nums2.length){
            if(count == i1){
                ind1 = nums2[j];
            }
            if(count == i2){
                ind2 = nums2[j];
            }
            j++;
            count++;
        }
        if((nums1.length+nums2.length)%2 == 0){
            return (ind1+ind2)/2.0;
        }
        else{
            return ind1;
        }
    }
}