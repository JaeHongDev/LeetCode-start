class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for(var pre: prerequisites){
            map.putIfAbsent(pre[0], new ArrayList<>());
            map.get(pre[0]).add(pre[1]);
        }

        var takes = new HashSet<Integer>();
        var taken = new HashSet<Integer>();

        for(var key: map.keySet()){
            if(!dfs(map, key, takes, taken)) return false;
        }
        return true;
    }

    boolean dfs(
        Map<Integer, List<Integer>> map,
        Integer key,  
        Set<Integer> takes,
        Set<Integer> taken
    ){
        if(takes.contains(key)) return false;
        if(taken.contains(key)) return true;

        if(!map.containsKey(key)) return true;
        
        for(var node: map.keySet()){
            takes.add(node);
            if(!dfs(map, node, takes, taken)) return false;

            takes.remove(node);
            taken.add(node);
        }
        return true;
    }
}