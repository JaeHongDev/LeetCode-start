import java.util.*;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();

        for(int[] time: times){
            graph.putIfAbsent(time[0], new HashMap<>());
            graph.get(time[0]).put(time[1], time[2]);
        }

        Queue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Map.Entry.comparingByValue());

        pq.add(new AbstractMap.SimpleEntry<>(k, 0));

        Map<Integer, Integer> dist = new HashMap<>();
        var max = 0;
        while(!pq.isEmpty()){
            var cur = pq.poll();
            var u = cur.getKey();
            var distU = cur.getValue();

            if(dist.containsKey(u)) continue;

            dist.put(u, distU);
            if(!graph.containsKey(u)) continue;
            for(var v: graph.get(u).entrySet()){
                var alt = distU + v.getValue();
                pq.add(new AbstractMap.SimpleEntry<>(v.getKey(), alt));
            }
        }

        if(dist.size() == n) return Collections.max(dist.values());
        return -1;
    }
}