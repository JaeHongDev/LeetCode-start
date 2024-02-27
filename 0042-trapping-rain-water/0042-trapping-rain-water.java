class Solution {
    public int trap(int[] height) {
        var volumn = 0;
        var left = 0; 
        var right = height.length - 1; 

        var leftMax = height[left]; 
        var rightMax = height[right];

        while(left < right){
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if(leftMax <= rightMax){
                volumn += leftMax - height[left];
                left++;
            }else{
                volumn += rightMax - height[right];
                right--;
            }
        }

        return volumn;
    }
}