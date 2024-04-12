class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        var result = new ArrayList<Integer>(); 

        for(int i = 0; i < expression.length(); i++){
            var c = expression.charAt(i); 

            if(c == '+' || c == '-' || c == '*'){
                var ll = diffWaysToCompute(expression.substring(0, i)); 
                var rl = diffWaysToCompute(expression.substring(i + 1));

                for(var l: ll){
                    for(var r: rl){
                        if(c == '+') result.add(l + r); 
                        else if(c == '-') result.add(l - r);
                        else if(c == '*') result.add(l * r);
                    }
                }
            }
        }
        if(result.isEmpty()) result.add(Integer.parseInt(expression)); 
        return result;
    }
}