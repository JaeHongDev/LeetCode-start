class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // -1 -1 0 1 2 4
        List<List<Integer>> answer = new ArrayList<>();

        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            var left = i + 1;
            var right = nums.length - 1;

            var num = nums[i];

            while(left < right){
                var sum = num + nums[left] + nums[right];


                if(sum == 0) {
                    answer.add(List.of(num, nums[left], nums[right]));

                    while(left < right && nums[left] == nums[left+1]) left++;
                    while(left < right && nums[right] == nums[right-1]) right--;
                    left++;
                    right--;
                }else if(sum > 0)  right--;
                else  left++;
            }
        }
        return answer;
    }
}