import java.util.*;
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();

        for(var time: times){
            graph.putIfAbsent(time[0], new HashMap<>());
            graph.get(time[0]).put(time[1], time[2]);
        }

        var pq = new PriorityQueue<Map.Entry<Integer, Integer>>(Map.Entry.comparingByValue());

        pq.add(new AbstractMap.SimpleEntry<>(k, 0));
        
        Map<Integer, Integer> dist = new HashMap<>();

        while(!pq.isEmpty()){
            var cur = pq.poll();
            var u = cur.getKey();
            var distU = cur.getValue();


            if(dist.continsKey(u)) continue;
            dist.put(new AbstractMap.SimpleEntry<>(u, distU));

            if(!graph.containsKey(u)) continue; 

            for(var node: graph.getKey(u).entrySet()){
                pq.poll(new AbstractMap.SimpleEntry<>(node.getKey(), node.getValue() + distU));
            }
        }

        if(dist.size() == n) return Collections.max(dist.getValues());
        return -1;
   }
}