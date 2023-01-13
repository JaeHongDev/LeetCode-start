/**
 * @param {string} s
 * @return {boolean}
 */
var isValid = function(s) {
    
    const stack = []; 

    const compare = (target,original) => {
        if(original === "(") return target === ")";
        if(original === "[") return target === "]";
        if(original === "{") return target === "}";
        return false;
    }
    const maxLength = s.length;
    for(let i = 0 ; i < maxLength;i++ ){
        if(stack.size !== 0 && compare(s[i], stack[stack.length-1])){
            stack.pop();
            continue; 
        } 
        stack.push(s[i]);
    }
    return stack.length === 0 
};