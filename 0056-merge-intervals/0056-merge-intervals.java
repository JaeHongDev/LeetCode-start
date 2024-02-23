class Solution {
    public int[][] merge(int[][] intervals) { 

        List<int[]> result = new ArrayList<>();

        var pq = new PriorityQueue<int[]>((n1, n2) -> n1[0] - n2[0]);

        for(var interval: intervals) pq.offer(interval);

        while(!pq.isEmpty()){

            if(result.isEmpty()) {
                result.add(pq.poll());
                continue;
            }

            var cur = pq.poll();

            var lastE = result.get(result.size() - 1);

            if(lastE[1] >= cur[0]){
                if(lastE[1] < cur[1]) lastE[1] = cur[1];
            } 
            else result.add(cur);
        }

        return result.stream().toArray(int[][]::new);
        

        
    }
}