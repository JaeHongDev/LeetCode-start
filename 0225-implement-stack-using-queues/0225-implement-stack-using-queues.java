class MyNode{
    int value; 
    MyNode pre; 

    MyNode(int x){
        this.value = x; 
    }
}
class MyStack {
    MyNode last;
    public MyStack() {
        
    }
    
    public void push(int x) {
        if(last == null){
            last = new MyNode(x);
            return ; 
        }
        var node = new MyNode(x); 
        node.pre = last; 
        last = node;
    }
    
    public int pop() {
        var value = last.value;
        last = last.pre; 
        return value;
        
    }
    
    public int top() {
        return last.value; 
    }
    
    public boolean empty() {
        return last == null;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */