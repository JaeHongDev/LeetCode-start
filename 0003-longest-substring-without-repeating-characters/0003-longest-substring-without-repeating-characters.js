/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function(s) {
    if(s.length <= 1) return s.length;
    let answer = 0; 
    const maxLength = s.length;
    const set = new Set();

    let ll = 0;
    let rl = 0; 
    
    while(ll <= rl && rl < maxLength){ 
        
        if(set.has(s[rl])){
            answer = Math.max(set.size,answer);
            set.delete(s[ll]);
            ll = ll + 1;
            continue;
        
        }
        set.add(s[rl]);
        rl = rl +1;
    }
    return Math.max(answer,set.size);
};