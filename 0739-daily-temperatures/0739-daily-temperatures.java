class Solution {
    public int[] dailyTemperatures(int[] temp) {
        var stack = new ArrayDeque<Integer>(); 
        var answer = new int[temp.length];

        for(int i = 0; i < temp.length; i++){
            while(!stack.isEmpty() && temp[stack.peek()] < temp[i]){
                var j = stack.pop();
                answer[j] = i - j;
            }
            stack.push(i);
        }
        return answer;
    }
}

/*
stack, 인덱스는 어떻게 해결하나?
*/