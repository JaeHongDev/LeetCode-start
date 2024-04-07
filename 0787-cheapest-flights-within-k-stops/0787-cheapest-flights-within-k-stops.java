class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<Node>> graph = new HashMap<>();

        for(var f: flights){
            graph.putIfAbsent(f[0], new ArrayList<>());
            graph.get(f[0]).add(new Node(f[1], f[2]));
        }

        var queue = new PriorityQueue<Node>((p1, p2) -> p1.cost - p2.cost);
        var dist = new HashMap<Integer, Integer>();

        queue.offer(new Node(src, 0, 0)); 
        dist.put(src, 0);

        var answer = Integer.MAX_VALUE;

        while(!queue.isEmpty()){
            var cur = queue.poll();

            if(cur.to == dst) return cur.cost;
            if(cur.k > k) continue;

            dist.put(cur.to, cur.k);

            if(!graph.containsKey(cur.to)) continue;
            for(var child: graph.get(cur.to)){ 
                var cost = cur.cost+ child.cost;
                if(!dist.containsKey(child.to) || dist.get(child.to) > cur.k + 1){
                    queue.offer(new Node(child.to, cur.k + 1, cost));
                }
            }
        }
        // 0 -> 1 5
        // 0 -> 3 2
        // 1 -> 4 1
        // 1 -> 2 5
        // 3 -> 1 2
        // 4 -> 2 1

        // 0 -> 3 -> 1 -> 4 -> 2
        System.out.println(dist);
        
        return -1;
        //return answer == Integer.MAX_VALUE ? -1: answer;
        //return dist.containsKey(dst) ? dist.get(dst) : -1;
    }
}

class Node {
    int to;
    int k;
    int cost;

    Node(int to, int cost){
        this.to = to; 
        this.cost = cost; 
    }

    Node(int to, int k, int cost){
        this.to = to; 
        this.k = k; 
        this.cost = cost;
    }
}
