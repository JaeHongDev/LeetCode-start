import java.util.*;
class Solution {
    public int search(int[] nums, int target) {

        var left = 0; 
        var right = nums.length - 1;

        while(left <= right){
            var mid = (left + right) / 2;

            if(nums[mid] == target) return mid;
            else if(nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
        
    }
}