class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[n];
        return dfs(source, adj, visited, destination);
    }
    boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, int destination){
        visited[node] = true;
        if(node == destination){
            return true;
        }
        for(Integer nbr : adj.get(node)){
            if(!visited[nbr]){
                if(dfs(nbr, adj, visited, destination)){
                    return true;
                }
            }
        }
        return false;
    }
}