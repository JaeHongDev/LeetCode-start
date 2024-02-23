class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for(int i = 0; i < numbers.length; i++){
            var expected = target - numbers[i];

            var r= Arrays.binarySearch(numbers, i + 1, numbers.length, expected);
            if(r <= -1) continue;
            if(r == i)continue;
            return new int[]{
                i + 1, 
                r + 1
           };
        }
        return new int[]{};
    }
}