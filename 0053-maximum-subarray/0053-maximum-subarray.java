class Solution {
    public int maxSubArray(int[] nums) {

        var cache = new int[nums.length]; 
        cache[0] = nums[0];
        var sum = nums[0];


        for(int i = 1; i < nums.length; i++){
            cache[i] = Math.max(cache[i-1] + nums[i], nums[i]);
            sum = Math.max(sum, cache[i]);
        }
        return sum;
    }
}