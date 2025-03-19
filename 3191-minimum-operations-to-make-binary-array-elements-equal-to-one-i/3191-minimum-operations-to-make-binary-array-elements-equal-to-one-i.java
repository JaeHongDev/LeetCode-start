class Solution {
    public int minOperations(int[] nums) {

        // 0 1 1 1 0 0
        // 1 0 0 1 0 0
        // 1 1 1 0 0 0
        // 1 1 1 1 1 1

        // 0 1 1 1 
        // 1 0 0 1
        // 1 1 1 0

        // 간단한 가설
        // 1부터 시작해서 뒤집음 마지막 요소가 1이 되면 다음으로 넘어감

        var answer = 0;
        var size = nums.length;
        for(int i = 0; i < size - 2; i++){ 
            if(nums[i] == 1) continue;
            
            nums[i] ^= 1;
            nums[i + 1] ^= 1;
            nums[i + 2] ^= 1;

            answer++;
        } 
        return (nums[size - 1] & nums[size -2] & nums[size - 3]) == 1 ? answer : -1;
    }

    void p(Object o) {System.out.println(o);}
}