class Solution {
    public int trap(int[] height) {
        var size = height.length;
        var sum = 0;
        var ll = 0;
        var rl = size - 1;
        var lmax = height[0];
        var rmax = height[rl];

        // 왼쪽과 오른쪽에서 출발해 가장 큰 기둥을 찾아가는 과정
        while(ll <= rl) {
            if(lmax <= rmax) {
                lmax = Math.max(lmax, height[ll]);
                sum += lmax - height[ll++];
            }else {
                rmax = Math.max(rmax, height[rl ]);
                sum += rmax - height[rl--];
            }
        }
        
        return sum;
    } 
}