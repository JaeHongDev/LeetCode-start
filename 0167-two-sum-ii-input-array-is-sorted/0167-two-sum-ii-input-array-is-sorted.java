class Solution {
    public int[] twoSum(int[] numbers, int target) {
        var ll = 0; 
        var rl = numbers.length -1; 

        while(ll <= rl){
            var sum = numbers[ll] + numbers[rl];

            if(sum == target) return new int[]{ll + 1, rl + 1 };
            else if(sum < target) ll++; 
            else rl--;
        }
        return new int[]{};
    }
}