class Solution {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> maps = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            if(maps.containsKey(target - nums[i])){
                return new int[]{
                    i,
                    maps.get(target - nums[i])
                };
            }
            maps.put(nums[i],i);
        }
        return null;
    }
}