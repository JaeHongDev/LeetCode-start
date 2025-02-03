class Solution {
    public int[] twoSum(int[] nums, int target) {
        var map = new HashMap<Integer, Integer>();

        for(int i = 0; i < nums.length; i++) {
            var value = map.get(target - nums[i]);
            if(value != null) return new int[]{i, value}; 
            else  map.put(nums[i], i); 
        }

        return null;
    }
}