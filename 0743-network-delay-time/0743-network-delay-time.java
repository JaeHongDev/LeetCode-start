import java.util.*;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();

        for(var time: times){
            graph.putIfAbsent(time[0], new HashMap<>());
            graph.get(time[0]).put(time[1], time[2]);
        }
        

        HashMap<Integer, Integer> dist = new HashMap<>();
        var pq = new PriorityQueue<Map.Entry<Integer, Integer>>((e1,e2) -> e1.getValue() - e2.getValue());
    
        pq.offer(new AbstractMap.SimpleEntry<>(k, 0));

        while(!pq.isEmpty()){
            System.out.println(dist);
            
            var cur = pq.poll();
            var u = cur.getKey();
            var distU = cur.getValue();

            if(dist.containsKey(u)) continue;
            
            dist.put(u, distU);
            if(!graph.containsKey(u)) continue;

            for(var child: graph.get(u).entrySet()){
                pq.offer(new AbstractMap.SimpleEntry<>(child.getKey(), child.getValue() + distU));
            }
        }

        if(dist.size() == n) return Collections.max(dist.values());
        return -1;
    }
}