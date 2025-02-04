class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));

        var size = nums.length;

        for(int i = 0; i < size - 2;i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;

            var start = i + 1;
            var end = size - 1;


            while(start < end) {
                var compare = nums[i] + nums[start] + nums[end];
                if(compare == 0) {
                    answer.add(List.of(nums[i], nums[start], nums[end]));

                    while(start < end && nums[start] == nums[start + 1]) start++;
                    while(start < end && nums[end] == nums[end - 1]) end--;
                    start++;
                    end--;
                }
                else if(compare < 0) start++;
                else end--;
            }
        }
        return answer; 
    }
}