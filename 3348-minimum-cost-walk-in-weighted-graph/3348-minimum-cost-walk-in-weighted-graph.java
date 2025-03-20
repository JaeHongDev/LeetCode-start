class DSU {
    int[] parent, rank, weights;

    public DSU (int n) {
        parent = new int[n];
        rank = new int[n];
        weights = new int[n];
        Arrays.fill(weights, Integer.MAX_VALUE);
        for(int i = 0; i < n; i++) parent[i] = i;
    }

    public int find(int x){
        if(x != parent[x]) parent[x] = find(parent[x]);
        return parent[x];
    }

    public void union(int x, int y, int weight){
        int xx = find(x);
        int yy=  find(y);
        if(rank[xx] < rank[yy]) parent[xx] = yy;
        else parent[yy] = xx; 

        weights[xx] = weights[yy] = weights[xx] & weights[yy] & weight;
        if(rank[xx] == rank[yy]) rank[xx]++;
    }

    public int minimumCostOfWalk(int x, int y) {
        if(x == y) return 0; 
        if(find(x) != find(y)) return -1;
        return weights[find(x)];
    }
}

class Solution {
    record Pair(int v, int w){}

    Map<Integer, List<Pair>> graph = new HashMap<>();
    List<Integer> answer = new ArrayList<>();
    // 그래프 먼저 만들어야 할 듯
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        DSU uf = new DSU(n);

        for(var edge: edges) uf.union(edge[0], edge[1], edge[2]);
        var result = new int[query.length];

        for(int i = 0; i < query.length; i++) result[i] = uf.minimumCostOfWalk(query[i][0], query[i][1]);

        return result;

    } 


    // int search(int[] query){ 
    //     var s = query[0];
    //     var e = query[1]; 
        
    //     p(Arrays.toString(query));
    //     if(!graph.containsKey(s)) return -1;
    //     if(!graph.containsKey(e)) return -1;
    //     if(s == e) return 0;
    //     p(">>");

    //     var queue = new PriorityQueue<Pair>((p1, p2) -> p1.w - p2.w);
    //     var visited = new boolean[10_000_01];
    //     var dist = new int[10_000_01];

    //     queue.add(new Pair(s, 0));

    //     while(!queue.isEmpty()){
    //         // p(queue);
    //         var start = queue.poll();

    //         if(!graph.containsKey(start.v)) continue;

    //         // 그래프에서 방문 여부를 어떻게 체크하더ㅓㅓ라
    //         for(var child: graph.get(start.v)) {
    //             // p(child);
    //             if(visited[child.v] || start.w + child.w < dist[child.v]) continue;
    //             dist[child.v] = start.w + child.w;
    //             visited[child.v] = true; 
    //             queue.add(new Pair(child.v, child.w + start.w));
    //         }
    //     }


    //     // p(Arrays.toString(dist));

    //     return dist[e] == 0 ? -1 : dist[e];
    // }


    // static void p(Object o) { System.out.println(o); }
}