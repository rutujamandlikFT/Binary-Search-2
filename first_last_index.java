//TC:)(log n)
//SC: O(1)
class Solution {
    
    private static int findLastIndex(int[] nums, int low, int high, int target){
        
        while(low<=high){
            int mid = low+(high-low)/2; 
             if(nums[mid]==target){
                 if(mid == nums.length-1 || nums[mid] < nums[mid+1] ){
                     return mid;
                 }else{
                     low = mid+1;
                 }
             } else if (nums[mid] < target){
                 low = mid+1;
             } else {
                 high = mid-1;
             }      
        }
        return -1;
    }
    
    private static int findFirstIndex(int[] nums, int target){
        int low = 0;
        int high = nums.length-1;
        
        while(low<=high){
            int mid = low+(high-low)/2; 
            if(nums[mid]==target) {
                if(mid == 0 || nums[mid] > nums[mid-1]){
                   return mid;
                }else{
                    high = mid-1;
                }
            }
            else if(nums[mid] > target ){
                high = mid-1;
            }else{
                    low = mid+1;
                }
        }
        return -1;
    }

    
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1,-1};
        int n = nums.length;
        if(nums[0] > target || nums[n-1] < target) return new int[]{-1,-1};
        int first = findFirstIndex(nums, target);
        if(first == -1) return new int[]{-1,-1};
        
        int last =  findLastIndex(nums, first, n-1, target);
        return new int[]{first,last};
    }
}
