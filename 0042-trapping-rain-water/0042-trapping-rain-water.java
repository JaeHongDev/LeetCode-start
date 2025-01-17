class Solution {
    public int trap(int[] height) {
        var ll = 0;
        var rl = height.length - 1; 

        var volume = 0;

        var lm = height[ll];
        var rm = height[rl];

        while(ll < rl) {
            lm = Math.max(height[ll], lm);
            rm = Math.max(height[rl], rm);

            if(height[ll] <= height[rl]) volume += lm - height[ll++];
            else volume += rm - height[rl--];
        } 

        return volume;
    }
}