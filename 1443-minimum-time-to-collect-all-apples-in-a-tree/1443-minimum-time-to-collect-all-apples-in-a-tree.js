/**
 * @param {number} n
 * @param {number[][]} edges
 * @param {boolean[]} hasApple
 * @return {number}
 */
var minTime = function (n, edges, hasApple) {

    // creating adjacency list
    let arr = []
    for (let i = 0; i < n; i++) {
        arr[i] = [];
    }
    for (let x of edges) {
        arr[x[0]].push(x[1]);
        arr[x[1]].push(x[0]);
    }
    const dfs = (previous, current, arr) => {

        let answer = 0;

        for(let x of arr[current]){
            if(x !== previous){
                let result = dfs(current, x, arr);
                if(result > 0 || hasApple[x]){
                    answer += result + 2;
                }
            }
        }
        return answer;
    }
    return dfs(-1, 0, arr, hasApple);
};