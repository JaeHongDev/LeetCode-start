class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        var graph = new HashMap<Integer, List<Integer>>();

        for(var e : edges){
            var v = e[0];
            var w = e[1];

            graph.putIfAbsent(v, new ArrayList<>());
            graph.putIfAbsent(w, new ArrayList<>());

            graph.get(v).add(w);
            graph.get(w).add(v); 
        }


        var visited = new boolean[n];
        var count = 0;

        for(int e = 0; e < n; e++){

            if(visited[e]) continue;
            var queue = new ArrayDeque<Integer>();

            queue.add(e);

            var nodeCount = 0;
            var vCount = 0;
            while(!queue.isEmpty()){
                var node = queue.poll();
                if(visited[node]) continue;

                nodeCount++;
                visited[node] = true; 
                if(!graph.containsKey(node)) {
                    continue; 
                }

                for(var next: graph.get(node)) {
                    if(visited[next]) continue; 
                    vCount++;
                    queue.add(next);
                }
                if (visited[node]) continue; 
            }

            if(fac(nodeCount - 1) == vCount) count++;
        }

        return count;
    }

    int fac(int n){
        if(n == 0) return 0;
        int r = 0;
        for(int i = 1; i <= n; i++)  r+=i;
        return r;
    }

    void p(Object o){
        System.out.println(o);
    }
}

/**
0 -> 1
0 -> 2
1 -> 2
1 -> 3
2 -> 3
 */