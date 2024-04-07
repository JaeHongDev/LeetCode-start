class Solution {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n == 1) return List.of(0);

        var graph = new HashMap<Integer, List<Integer>>();

        for(var edge: edges){
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.putIfAbsent(edge[1], new ArrayList<>() );
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        List<Integer> leaves = new ArrayList<>();

        for(int i = 0; i < n;i++){
            if(graph.get(i).size() == 1) leaves.add(i);
        }

        while(n > 2){
            n-= leaves.size();
            List<Integer> newLeaves = new ArrayList<>(); 

            for(var leaf:leaves){
                var nei = graph.get(leaf).get(0);
                graph.get(nei).remove(leaf);

                if(graph.get(nei).size() == 1) newLeaves.add(nei);
            }
            leaves = newLeaves;
        
        }
        
        return leaves;
        
    }
}