class Solution {
    public boolean isValid(String s) {
        var stack = new ArrayDeque<>();

        var map = Map.of(
            ')', '(', 
            '}', '{', 
            ']', '['
            );

        for(var c: s.toCharArray()){
            if(map.containsKey(c)) {
                if(stack.isEmpty() || stack.peek() != map.get(c)) return false;
                stack.pop();
            }else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}