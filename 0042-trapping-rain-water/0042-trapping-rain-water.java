class Solution {
    public int trap(int[] height) {
        Deque<Integer> stack = new ArrayDeque<>();

        var volumn = 0;

        for(int i = 0; i < height.length; i++){
            while(!stack.isEmpty() && height[i] > height[stack.peek()]){
                var top = stack.pop();

                if(stack.isEmpty()) break;

                var distance = i - stack.peek() - 1;

                var water = Math.min(height[i], height[stack.peek()]) - height[top];

                volumn += distance * water;
            }
            stack.push(i);
        }
        return volumn;
        
    }
}