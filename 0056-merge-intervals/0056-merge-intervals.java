class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> answer = new ArrayList<>(); 

        var pq = new PriorityQueue<int[]>((e1,e2) -> {
            var compared = e1[0] - e2[0]; 

            if(compared == 0) return e1[1] - e2[1]; 
            return compared; 
        });

        for(var arr: intervals) pq.offer(arr);

        while(!pq.isEmpty()){
            if(answer.isEmpty()) {
                answer.add(pq.poll()); 
                continue;
            }


            var cur = pq.poll(); 

            var last = answer.get(answer.size() - 1);

            // 마지막으로 저장된 노드와 추가할 노드를비교할 때 
            if(last[1] >= cur[0]) last[1] = Math.max(last[1], cur[1]);
            else answer.add(cur);
       }
       return answer.stream().toArray(int[][]::new);
        
    }
}