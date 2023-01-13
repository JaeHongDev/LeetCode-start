/**
 * @param {string} s
 * @return {boolean}
 */
var isValid = function(s) {
    const compare = (target,original) => {
        if(original === "(") return target === ")";
        if(original === "[") return target === "]";
        if(original === "{") return target === "}";
        return false;
    }
    return s.split("").reduce((pre,cal) => {
        if(pre.length === 0) return [cal];
        if(compare(cal, pre[pre.length-1])){
            pre.pop();
            return pre; 
        }
        pre.push(cal);
        return pre;
    }, []).length === 0;
};