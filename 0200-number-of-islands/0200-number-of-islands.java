class Solution {

    int[] dx = new int[]{0, 0, 1, -1}; 
    int[] dy = new int[]{1, -1, 0, 0}; 
    public int numIslands(char[][] grid) {

        int answer = 0;
        var M = grid.length;
        var N = grid[0].length;


        var visited = new boolean[M][N];

        for(int i = 0; i < grid.length;i++){
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '0') continue;
                answer++;

                var queue = new ArrayDeque<int[]>();
                queue.push(new int[]{i, j});


                while(!queue.isEmpty()){
                    var cur = queue.poll();
                    if(visited[cur[0]][cur[1]]) continue;
                    visited[cur[0]][cur[1]] = true;
                
                    grid[cur[0]][cur[1]] = '0';

                    for(int k = 0; k < 4; k++){
                        var nextX = cur[0] + dx[k];
                        var nextY = cur[1] + dy[k]; 

                        if(nextX < 0 || nextX >= M) continue; 
                        if(nextY < 0 || nextY >= N) continue; 
                        if(grid[nextX][nextY] == '0') continue; 

                        queue.offer(new int[]{nextX, nextY}); 
                    }
                }   
            }
        }
        return answer;
    }
} 

// 2이상 땅인 경우 섬

// 1,1 부터 들어가서 땅이 몇개 인지 확인 땅이라면 물로 바꿔줌