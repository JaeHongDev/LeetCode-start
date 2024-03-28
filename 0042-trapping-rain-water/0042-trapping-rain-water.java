class Solution {
    public int trap(int[] height) {
        var answer = 0;
        var left = 0; 
        var right = height.length - 1; 

        
        var leftMax = height[left] ; 
        var rightMax = height[right];
        while(left < right){
            leftMax = Math.max(height[left], leftMax); 
            rightMax = Math.max(height[right], rightMax); 

            if(leftMax <= rightMax) answer += leftMax - height[left++];
            else answer += rightMax - height[right--];
        }
        return answer;
    }
}