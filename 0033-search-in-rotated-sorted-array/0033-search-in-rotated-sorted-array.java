class Solution {
    public int search(int[] nums, int target) {
        var left = 0; 
        var right = nums.length -1;

        while(left < right){
            int mid = left + (right - left) / 2;

            if(nums[mid] > nums[right]) left = mid + 1;
            else right = mid;
        }

        var pivot = left;
        left = 0;
        right = nums.length - 1;

        while(left <= right){
            var mid = left + (right - left) / 2;
            var midPivot = (mid + pivot) % nums.length;

            if(nums[midPivot] < target) left = mid + 1;
            else if(nums[midPivot] > target) right = mid - 1; 
            else return midPivot;
        }
        return -1;
    }
}