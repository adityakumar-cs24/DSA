class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        boolean[] visited = new boolean[V];
        int[] curPath = new int[V];
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < V; i++){
            if(!visited[i]){
                dfs(i, graph, visited, curPath);
            }
        }
        for(int i = 0; i < V; i++){
            if(curPath[i] == 0){
                ans.add(i);
            }
        }
        return ans;
    }
    boolean dfs(int node, int[][] graph, boolean[] visited, int[] curPath){
        visited[node] = true;
        curPath[node] = 1;
        
        for(int nbr : graph[node]){
            if(!visited[nbr]){
                if(dfs(nbr, graph, visited, curPath)){
                    return true;
                }
            }
            else if(curPath[nbr] == 1){
                return true;
            }
        }
        curPath[node] = 0;
        return false;
    } 
}