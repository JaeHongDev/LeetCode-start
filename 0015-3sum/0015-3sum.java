class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> answer = new ArrayList<>();
        
        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            var ll =  i + 1; 
            var rl = nums.length - 1;
            while(ll < rl){
                var sum = nums[i] + nums[ll] + nums[rl];
                if(sum < 0) ll += 1 ;
                else if(sum > 0) rl -= 1; 
                if(sum == 0){
                    answer.add(List.of(nums[i], nums[ll], nums[rl]));
                    while(ll < rl && nums[ll] == nums[ll + 1]) ll++;
                    while(ll < rl && nums[rl] == nums[rl - 1]) rl--;
                    ll++;
                    rl--;
                }
            }
        }
        return answer;
    }
}