class Solution {
    Map<String, PriorityQueue<String>> map = new HashMap<>();
    List<String> answer = new LinkedList<>();
    public List<String> findItinerary(List<List<String>> tickets) {

        for(var ticket: tickets){
            map.putIfAbsent(ticket.get(0), new PriorityQueue<String>());
            map.get(ticket.get(0)).add(ticket.get(1));
        }


        dfs("JFK");

        return answer;
    }

    void dfs(String start){
        var queue = map.get(start);
        while(queue != null && !queue.isEmpty()) dfs(queue.poll());

        answer.add(0, start);
    }
}