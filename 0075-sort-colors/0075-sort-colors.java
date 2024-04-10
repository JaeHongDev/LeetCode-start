class Solution {
    public void sortColors(int[] nums) {
        int red = 0; 
        int white = 0; 
        int blue = nums.length; 

        while(white < blue){
            if(nums[white] < 1){
                var temp = nums[red];
                nums[red++] = nums[white]; 
                nums[white++] = temp; 
            }else if(nums[white] > 1){
                var temp = nums[white];
                nums[white] = nums[--blue];
                nums[blue] = temp;
            }else white++;
        }
    }
}